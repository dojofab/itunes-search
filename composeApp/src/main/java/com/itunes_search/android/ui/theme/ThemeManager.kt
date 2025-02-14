package com.itunes_search.android.ui.theme

import com.itunes_search.design.Theme
import com.itunes_search.design.ThemePreset
import com.itunes_search.design.ThemeProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object ThemeManager {
    private val _themeFlow = MutableStateFlow(ThemeProvider.get())
    val themeFlow = _themeFlow.asStateFlow()
    val theme: Theme
        get() = _themeFlow.value
    val themePresetNames = ThemePreset.NAMES

    fun onIsDarkSchemeChanged(isDarkScheme: Boolean) {
        _themeFlow.update { ThemeProvider.get(preset = it.themePreset, isDarkScheme = isDarkScheme) }
    }

    fun onThemePresetNameChanged(presetName: String) {
        _themeFlow.update {
            ThemeProvider.get(
                presetName = presetName,
                isDarkScheme = it.isDarkScheme
            )
        }
    }
}
