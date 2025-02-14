package com.itunes_search.design

import kotlin.native.concurrent.ThreadLocal

private data class ThemeKey(
    val id: String,
    val isDark: Boolean
) {
    companion object {
        private const val DEFAULT = "default"
        val DEFAULT_LIGHT = ThemeKey(DEFAULT, false)
        val DEFAULT_DARK = ThemeKey(DEFAULT, true)
    }
}

@ThreadLocal
object ThemeProvider {
    private val themes =
        mutableMapOf(
            ThemeKey.DEFAULT_LIGHT to buildTheme(
                ThemePreset.DEFAULT, isDarkScheme = false),
            ThemeKey.DEFAULT_DARK to buildTheme(
                ThemePreset.DEFAULT, isDarkScheme = true)
        )

    fun get(
        presetName: String,
        isDarkScheme: Boolean = false
    ): Theme =
        try {
            get(ThemePreset.valueOf(presetName), isDarkScheme)
        } catch (e: Exception) {
            get(ThemePreset.DEFAULT, isDarkScheme)
        }

    fun get(
        preset: ThemePreset = ThemePreset.DEFAULT,
        isDarkScheme: Boolean = false
    ): Theme {
        val key = ThemeKey(preset.name, isDarkScheme)
        var theme = themes[key]

        if (theme != null) {
            return theme
        }

        theme = buildTheme(preset, isDarkScheme)
        themes[key] = theme

        return theme
    }

    private fun buildTheme(
        themePreset: ThemePreset,
        isDarkScheme: Boolean = false
    ): Theme {
        val colorTable = ColorTable.appColors(
            themePreset,
            isDarkScheme
        )
        return Theme(
            colors = colorTable,
            themePreset = themePreset
        )
    }
}