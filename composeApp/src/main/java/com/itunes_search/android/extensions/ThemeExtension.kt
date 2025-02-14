package com.itunes_search.android.extensions

import androidx.compose.ui.graphics.Color
import com.itunes_search.android.ui.theme.ThemeManager
import com.itunes_search.android.util.ColorCache
import com.itunes_search.design.Theme

val Theme.onBackgroundMutedColor: Color
    get() = ColorCache[ThemeManager.theme.onBackgroundMuted]