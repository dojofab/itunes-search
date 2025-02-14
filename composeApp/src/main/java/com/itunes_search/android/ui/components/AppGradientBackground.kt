package com.itunes_search.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.core.graphics.ColorUtils
import com.itunes_search.android.extensions.appBackgroundGradient
import com.itunes_search.android.extensions.toColor
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.android.ui.theme.ThemeManager
import com.itunes_search.android.util.ColorCache
import com.itunes_search.design.ColorTokens
import com.itunes_search.design.DesignTokens

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
                        MaterialTheme.colorScheme.background,
                        MaterialTheme.colorScheme.background,
                        MaterialTheme.colorScheme.onPrimary
                    )
                )
            )
            .fillMaxSize()
    ) {
        content()
    }
}

/*private fun cachedColor(
    color: Long,
    alpha: Float = 1.0f
) = ColorCache.get(
    if (alpha == 1.0f) {
        color
    } else {
        ColorUtils
            .setAlphaComponent(
                color.toInt(),
                (alpha * 0xFF).toInt()
            ).toLong()
    }
)

@Composable
fun AppGradientBackground(
    modifier: Modifier = Modifier,
    gradientScale: Float = DesignTokens.Content.GradientBackgroundSizeScale,
    content: @Composable () -> Unit,
) {
    val theme = ThemeManager.themeFlow.collectAsState().value
    var size by remember { mutableStateOf(IntSize.Zero) }
    val gradientHighlight = cachedColor(theme.colors.gradientBackground)
    val gradientBase = cachedColor(theme.colors.gradientBackground, 0.0f)

    Box(
        modifier =
        modifier
            .fillMaxSize()
            .onGloballyPositioned { layoutCoordinates ->
                size = layoutCoordinates.size
            }.background(
                Brush.appBackgroundGradient(
                    highlightColor = gradientHighlight,
                    baseColor = gradientBase,
                    size =
                    if (size.width == 0) {
                        Float.POSITIVE_INFINITY
                    } else {
                        size.width.toFloat() * minOf(maxOf(gradientScale, 0.0f), 1.0f)
                    }
                )
            )
    ) {
        content()
    }
}*/

@Preview
@Composable
fun AppGradientBackgroundPreview() {
    AppTheme {
        AppGradientBackground {

        }
    }
}
