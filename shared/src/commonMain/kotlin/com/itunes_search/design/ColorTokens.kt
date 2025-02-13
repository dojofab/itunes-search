package com.itunes_search.design

import com.itunes_search.ui.setAlphaComponent

object ColorTokens {
    const val primary: Long = 0xFFD0BCFF
    const val primaryContainer: Long = 0xFF4F378B
    const val secondary: Long = 0xFFCCC2DC
    const val secondaryContainer: Long = 0xFF4A4458
    const val tertiary: Long = 0xFFEFB8C8
    const val tertiaryContainer: Long = 0xFF633B48
    const val surface: Long = 0xFF1C1B1F
    const val surfaceVariant: Long = 0xFF49454F
    const val background: Long = 0xFF1C1B1F
    const val error: Long = 0xFFF2B8B5
    const val errorContainer: Long = 0xFF8C1D18
    const val onPrimary: Long = 0xFF371E73
    const val onPrimaryContainer: Long = 0xFFEADDFF
    const val onSecondary: Long = 0xFF332D41
    const val onSecondaryContainer: Long = 0xFFE8DEF8
    const val onTertiary: Long = 0xFF492532
    const val onTertiaryContainer: Long = 0xFFFFD8E4
    const val onSurface: Long = 0xFFE6E1E5
    const val onSurfaceVariant: Long = 0xFFCAC4D0
    const val onBackground: Long = 0xFFE6E1E5
    const val onError: Long = 0xFF601410
    const val onErrorContainer: Long = 0xFFF9DEDC
    const val outline: Long = 0xFF938F99
    const val shadow: Long = 0xFF000000
    const val surfaceTint: Long = 0xFFD0BCFF
    const val inverseSurface: Long = 0xFFE6E1E5
    const val inverseOnSurface: Long = 0xFF313033
    const val inversePrimary: Long = 0xFF6750A4
    const val scrim: Long = 0xFF000000
    const val placeholder: Long = 0xFF1C1C1E
    const val shimmer: Long = 0xFFFFFFFF

    val onBackgroundMuted: Long
        get() = setAlphaComponent(onBackground, DesignTokens.Content.MutedContentOpacity)
}
