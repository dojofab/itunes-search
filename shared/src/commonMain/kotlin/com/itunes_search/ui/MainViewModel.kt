package com.itunes_search.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itunes_search.data.faker.Faker
import com.itunes_search.data.repository.ContentRepository
import com.itunes_search.domain.Content
import com.itunes_search.utils.AsyncError
import com.itunes_search.utils.AsyncOperation
import com.itunes_search.utils.RepositoryError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

data class ContentUiState(
    val isLoading: Boolean = false,
    val searchValue: String? = null,
    val contents: List<Content>? = null,
    val error: RepositoryError? = null
) {
    companion object {
        val defaultValue: ContentUiState by lazy {
            ContentUiState()
        }

        val fakeValue = ContentUiState(
            contents = Faker.content.buildMany(20)
        )
    }
}

open class MainViewModel: ViewModel(), KoinComponent {
    private val contentRepository: ContentRepository by inject()

    var uiStateFlow = MutableStateFlow(ContentUiState.defaultValue)
        private set

    fun updateSearch(value: String) {
        uiStateFlow.update {
            it.copy(searchValue = value)
        }

        search()
    }

    fun search() {
        viewModelScope.launch {
            contentRepository.search(
                term = uiStateFlow.value.searchValue?.takeIf { it.isNotBlank() },
                limit = null
            ).collect { asyncOperation ->
                when(asyncOperation) {
                    is AsyncOperation.Loading -> {
                        uiStateFlow.update { it.copy(error = null, isLoading = true) }
                    }

                    is AsyncOperation.Loaded -> {
                        uiStateFlow.update {
                            it.copy(
                                isLoading = false,
                                contents = asyncOperation.value.results
                           )
                        }
                    }

                    is AsyncOperation.Failed -> {
                        uiStateFlow.update {
                            it.copy(
                                error = AsyncError.getRepositoryError(asyncOperation.error),
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}