package com.itunes_search.android.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.itunes_search.android.annotations.DevicePreviews
import com.itunes_search.android.extensions.themePadding
import com.itunes_search.android.extensions.toColor
import com.itunes_search.android.ui.components.AppGradientBackground
import com.itunes_search.android.ui.components.ContentItem
import com.itunes_search.android.ui.components.SearchBar
import com.itunes_search.android.ui.components.TopBar
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.design.ColorTokens
import com.itunes_search.design.DesignTokens
import com.itunes_search.design.SizePreset
import com.itunes_search.domain.Content
import com.itunes_search.ui.ContentUiState

@Composable
fun MainScreen(
    onContentClick: (Content) -> Unit,
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
        onSearch = viewModel::search
    )
}

@Composable
private fun MainView(
    uiState: ContentUiState,
    onContentClick: (Content) -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar()
        },
    ) { padding ->
        AppGradientBackground {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1.0f)
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                SearchBar(
                    onSearch = onSearch
                )

                LazyVerticalGrid(
                    modifier = Modifier,
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(DesignTokens.Spacing.h(SizePreset.Md).dp)
                ) {
                    items(uiState.contents) { content ->
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

@DevicePreviews
@Composable
private fun MainViewPreview() {
    AppTheme {
        MainView(
            uiState = ContentUiState.defaultValue,
            onContentClick = {},
            onSearch = {}
        )
    }
}


