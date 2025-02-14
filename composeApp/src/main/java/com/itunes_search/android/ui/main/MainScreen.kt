package com.itunes_search.android.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.itunes_search.android.R
import com.itunes_search.android.annotations.DevicePreviews
import com.itunes_search.android.extensions.themePadding
import com.itunes_search.android.extensions.themeSpacerV
import com.itunes_search.android.ui.components.AppGradientBackground
import com.itunes_search.android.ui.components.ContentItem
import com.itunes_search.android.ui.components.SearchBar
import com.itunes_search.android.ui.components.TopBar
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.design.DesignTokens
import com.itunes_search.design.SizePreset
import com.itunes_search.domain.ContentModel
import com.itunes_search.ui.ContentUiState
import com.itunes_search.utils.Message
import com.itunes_search.utils.RepositoryError
import com.itunes_search.utils.RepositoryErrorCode

@Composable
fun MainScreen(
    onContentClick: (ContentModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.search()
    }

    MainView(
        uiState = uiState,
        onContentClick = onContentClick,
        modifier = modifier,
        onSearch = viewModel::updateSearch
    )
}

@Composable
private fun MainView(
    uiState: ContentUiState,
    onContentClick: (ContentModel) -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
            )
        },
    ) { padding ->
        AppGradientBackground {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1.0f)
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .themePadding(),
                    value = uiState.searchValue ?: "",
                    onSearch = onSearch
                )

                uiState.error?.let {
                    ErrorView(
                        error = it,
                        onRetry = {}
                    )
                }

                uiState.contents?.let { contents ->
                    if (contents.isEmpty()) {
                        NoContentsAvailable()
                    }

                    LazyVerticalGrid(
                        modifier = Modifier,
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(DesignTokens.Spacing.h(SizePreset.Md).dp)
                    ) {
                        items(contents) { content ->
                            ContentItem(
                                modifier = Modifier
                                    .themePadding(SizePreset.Xs)
                                    .height(DesignTokens.Content.ContentHeight.dp),
                                content = content,
                                onContentClick = {
                                    onContentClick(content)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ErrorView(
    error: RepositoryError,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error.errorMessage,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.themeSpacerV())

        Button(
            modifier = Modifier.fillMaxWidth(0.4f),
            onClick = onRetry
        ) {
            Text(
                text = stringResource(R.string.retry),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
private fun NoContentsAvailable(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.no_available_contents),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@DevicePreviews
@Composable
private fun ErrorViewPreview() {
    AppTheme {
        ErrorView(
            error = RepositoryError(
                errorCode = RepositoryErrorCode.NetworkError,
                errorMessage = Message.NETWORK_ERROR
            ),
            onRetry = {}
        )
    }
}

@DevicePreviews
@Composable
private fun MainViewPreview() {
    AppTheme {
        MainView(
            uiState = ContentUiState.fakeValue,
            onContentClick = {},
            onSearch = {}
        )
    }
}


