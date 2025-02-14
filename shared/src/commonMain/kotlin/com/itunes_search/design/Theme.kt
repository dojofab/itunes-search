package com.itunes_search.design

import com.itunes_search.ui.setAlphaComponent

/**
 * Theme interface representing
 */
data class Theme(
    val colors: ColorTable,
    val themePreset: ThemePreset,
    val typography: Typography = Typography,
) {
    val gradientBackground: Long
        get() = themePreset.gradientBackgroundColor(colors.isDarkScheme)
    val onBackgroundMuted: Long
        get() = setAlphaComponent(colors.surface, DesignTokens.Content.MutedContentOpacity)


    val isDarkScheme: Boolean
        get() = colors.isDarkScheme
}
