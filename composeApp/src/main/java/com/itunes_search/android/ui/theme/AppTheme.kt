package com.itunes_search.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import com.itunes_search.design.Theme

@Composable
fun AppTheme(
    theme: Theme = ThemeManager.theme,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = darkColorScheme(), // Force to dark scheme for this demo(should be theme.materialColorScheme() to support light/dark mode)
        typography = theme.materialTypography(),
        shapes = theme.materialShapes(),
        content = content
    )
}
