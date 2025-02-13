import assertk.assertThat
import assertk.assertions.isEqualTo
import com.itunes_search.data.faker.Faker
import com.itunes_search.data.repository.ContentRepository
import com.itunes_search.domain.SearchResponse
import com.itunes_search.ui.MainViewModel
import com.itunes_search.utils.AsyncOperation
import com.itunes_search.utils.Message
import com.itunes_search.utils.RepositoryError
import com.itunes_search.utils.RepositoryErrorCode
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.serialization.SerializationException
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.get
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest: KoinTest {

    private val viewModel = MainViewModel()

    // Koin module
    private val testModule = module {
        single<ContentRepository> { FakeContentRepository() }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setUp() {
        // Start Koin
        startKoin {
            modules(testModule)
        }
        // Set the main dispatcher for testing
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @AfterTest
    fun tearDown() {
        // Stop Koin
        stopKoin()
        Dispatchers.resetMain()
    }

    @Test
    fun test_update_search_function_with_empty_value() {
        val searchValue = ""

        viewModel.updateSearch(searchValue)

        assertThat(viewModel.uiStateFlow.value.searchValue).isEqualTo("")
    }

    @Test
    fun test_update_search_function_with_value() {
        val searchValue = "test"
        viewModel.updateSearch(searchValue)
        assertThat(viewModel.uiStateFlow.value.searchValue).isEqualTo(searchValue)
    }

    @Test
    fun test_search_function_when_api_call_is_loading() = runTest {
        val fakeRepository = get<ContentRepository>() as FakeContentRepository
        fakeRepository.setTestMode(TestMode.Loading)

        viewModel.search()

        advanceUntilIdle()

        assertThat(viewModel.uiStateFlow.value.isLoading).isEqualTo(true)
    }

    @Test
    fun test_search_function_when_api_triggers_network_error() = runTest {
        val fakeRepository = get<ContentRepository>() as FakeContentRepository
        fakeRepository.setTestMode(TestMode.FailedNetwork)

        viewModel.search()

        advanceUntilIdle()

        assertThat(viewModel.uiStateFlow.value.error).isEqualTo(networkError)
    }

    @Test
    fun test_search_function_when_api_triggers_serialization_error() = runTest {
        val fakeRepository = get<ContentRepository>() as FakeContentRepository
        fakeRepository.setTestMode(TestMode.FailedSerialization)

        viewModel.search()

        advanceUntilIdle()

        assertThat(viewModel.uiStateFlow.value.error).isEqualTo(serializationError)
    }

    @Test
    fun test_search_function_when_api_call_triggers_generic_error() = runTest {
        val fakeRepository = get<ContentRepository>() as FakeContentRepository
        fakeRepository.setTestMode(TestMode.FailedUnknown)

        viewModel.search()

        advanceUntilIdle()

        assertThat(viewModel.uiStateFlow.value.error).isEqualTo(genericError)
    }

    @Test
    fun test_search_function_when_api_call_is_successful() = runTest {
        val fakeRepository = get<ContentRepository>() as FakeContentRepository
        fakeRepository.setTestMode(TestMode.Success)

        viewModel.search()

        advanceUntilIdle()

        assertThat(viewModel.uiStateFlow.value.contents).isEqualTo(contents)
    }

}

val contents = Faker.content.buildMany(10)

val networkError = RepositoryError(
    errorCode = RepositoryErrorCode.NetworkError,
    errorMessage = Message.NETWORK_ERROR
)

val serializationError = RepositoryError(
    errorCode = RepositoryErrorCode.SerializationError,
    errorMessage = Message.SOMETHING_WENT_WRONG
)

val genericError = RepositoryError(
    errorCode = RepositoryErrorCode.HttpError,
    errorMessage = Message.SERVER_ERROR
)

enum class TestMode {
    Success,
    Loading,
    FailedNetwork,
    FailedSerialization,
    FailedUnknown
}

class FakeContentRepository(private var mode: TestMode = TestMode.Success) : ContentRepository {
    override suspend fun search(term: String?, limit: Int?): Flow<AsyncOperation<SearchResponse>> {
        return when (mode) {
            TestMode.Success -> successResponse
            TestMode.Loading -> loadingResponse
            TestMode.FailedNetwork -> failedNetworkResponse
            TestMode.FailedSerialization -> failedSerializationResponse
            TestMode.FailedUnknown -> failedGenericResponse
        }
    }

    fun setTestMode(newMode: TestMode) {
        mode = newMode
    }
}

val successResponse = flowOf(
    AsyncOperation.Loaded(
        SearchResponse(
            resultCount = 10,
            results = contents
        )
    )
)

val loadingResponse = flowOf(AsyncOperation.Loading)

val failedNetworkResponse = flowOf(
    AsyncOperation.Failed(error = UnresolvedAddressException())
)

val failedSerializationResponse = flowOf(
    AsyncOperation.Failed(error = SerializationException())
)

val failedGenericResponse = flowOf(
    AsyncOperation.Failed(error = RuntimeException())
)