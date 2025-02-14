package com.itunes_search.android.ui.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.android.ui.theme.ThemeManager

@Composable
fun AppScreen(
    modifier: Modifier = Modifier
) {
    AppTheme {
        AppNavHost(modifier = modifier)
    }
}

@Preview
@Composable
private fun AppScreePreview() {
    AppScreen()
}