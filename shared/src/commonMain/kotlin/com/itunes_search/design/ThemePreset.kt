package com.itunes_search.design

import com.itunes_search.design.palettes.DefaultColorPalette
import com.itunes_search.design.palettes.TailwindColorPalette
import com.itunes_search.design.palettes.TonalColorPalette

enum class ThemePreset(
    private val palette: TonalColorPalette,
    private val swatchName: String
) {
    DEFAULT(DefaultColorPalette, DefaultColorPalette.SWATCH_NAME_DEFAULT),

    RED_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_RED),
    ORANGE_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_ORANGE),
    AMBER_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_AMBER),
    YELLOW_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_YELLOW),
    LIME_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_LIME),
    GREEN_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_GREEN),
    EMERALD_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_EMERALD),
    TEAL_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_TEAL),
    CYAN_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_CYAN),
    SKY_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_SKY),
    BLUE_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_BLUE),
    INDIGO_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_INDIGO),
    VIOLET_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_VIOLET),
    PURPLE_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_PURPLE),
    FUCHSIA_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_FUCHSIA),
    PINK_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_PINK),
    ROSE_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_ROSE),
    SLATE_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_SLATE),
    GRAY_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_GRAY),
    ZINC_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_ZINC),
    NEUTRAL_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_NEUTRAL),
    STONE_1(TailwindColorPalette, TailwindColorPalette.SWATCH_NAME_STONE);

    fun primaryColor(isDarkScheme: Boolean): Long = palette.primaryColor(swatchName, isDarkScheme)

    fun primaryContentColor(isDarkScheme: Boolean): Long = palette.primaryContentColor(swatchName, isDarkScheme)

    fun gradientBackgroundColor(isDarkScheme: Boolean): Long = palette.gradientBackgroundColor(swatchName, isDarkScheme)

    companion object {
        val NAMES = values().map { it.name }
    }
}
