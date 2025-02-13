package com.itunes_search.android.ui.main

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.itunes_search.android.annotations.DevicePreviews
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.domain.Content
import com.itunes_search.ui.ContentUiState

@Composable
fun MainScreen(
    adaptiveInfo: WindowAdaptiveInfo,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.search()
    }

    MainView(
        adaptiveInfo = adaptiveInfo,
        uiState = uiState,
        onItemClick = onItemClick,
        modifier = modifier
    )
}

@Composable
private fun MainView(
    adaptiveInfo: WindowAdaptiveInfo,
    uiState: ContentUiState,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold { _ ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(uiState.contents) { content ->
                ContentItemView(
                    content = content
                )
            }
        }
    }
}

@Composable
private fun ContentItemView(
    content: Content,
    modifier: Modifier = Modifier
) {
    Text(content.wrapperType)
}

@DevicePreviews
@Composable
private fun MainViewPreview() {
    AppTheme {
        MainView(
            adaptiveInfo = currentWindowAdaptiveInfo(),
            uiState = ContentUiState.defaultValue,
            onItemClick = {}
        )
    }
}


