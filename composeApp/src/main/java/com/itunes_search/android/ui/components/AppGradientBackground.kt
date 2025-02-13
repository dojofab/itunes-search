package com.itunes_search.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.itunes_search.android.extensions.toColor
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.design.ColorTokens

@Composable
fun AppGradientBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        ColorTokens.background.toColor(),
                        ColorTokens.background.toColor(),
                        ColorTokens.onPrimary.toColor()
                    )
                )
            )
            .fillMaxSize()
    ) {
        content()
    }
}

@Preview
@Composable
fun AppGradientBackgroundPreview() {
    AppTheme {
        AppGradientBackground {

        }
    }
}
