package com.itunes_search.android.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.itunes_search.android.annotations.DevicePreviews
import com.itunes_search.android.extensions.themePaddingBottom
import com.itunes_search.android.ui.theme.AppTheme

@Composable
fun MainScreen(
    adaptiveInfo: WindowAdaptiveInfo,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    MainView(
        adaptiveInfo = adaptiveInfo,
        onItemClick = onItemClick,
        modifier = modifier
    )
}

@Composable
private fun MainView(
    adaptiveInfo: WindowAdaptiveInfo,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold { padding ->
        Column(
            modifier =
            modifier
                .fillMaxWidth()
                .fillMaxHeight(1.0f)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text("TODO: Main View")
            Button(
                modifier = Modifier.themePaddingBottom(),
                onClick = { onItemClick("Hello Word") },
            ) {
                Text("Abort")
            }
        }
    }
}

@DevicePreviews
@Composable
private fun MainViewPreview() {
    AppTheme {
        MainView(
            adaptiveInfo = currentWindowAdaptiveInfo(),
            onItemClick = {}
        )
    }
}


