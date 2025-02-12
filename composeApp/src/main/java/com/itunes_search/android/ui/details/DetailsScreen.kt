package com.itunes_search.android.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.itunes_search.android.annotations.DevicePreviews
import com.itunes_search.android.ui.theme.AppTheme

@Composable
fun DetailsScreen(
    adaptiveInfo: WindowAdaptiveInfo,
    item: String,
    modifier: Modifier = Modifier
) {
    DetailsView(
        adaptiveInfo = adaptiveInfo,
        item = item,
        modifier = modifier
    )
}

@Composable
private fun DetailsView(
    adaptiveInfo: WindowAdaptiveInfo,
    item: String,
    modifier: Modifier = Modifier
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
            Text(item)
        }
    }
}

@DevicePreviews
@Composable
private fun DetailsViewPreview() {
    AppTheme {
        DetailsView(
            adaptiveInfo = currentWindowAdaptiveInfo(),
            item = "Test"
        )
    }
}
