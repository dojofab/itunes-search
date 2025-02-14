package com.itunes_search.design.palettes

import com.itunes_search.design.DesignTokens
import com.itunes_search.ui.setAlphaComponent


internal interface TonalColorPalette {
    val swatches: Map<String, ColorSwatch>

    operator fun get(
        name: String,
        tone: Int
    ): Long? = swatches[name]?.tone(tone)

    fun primaryColor(
        swatchName: String,
        isDarkScheme: Boolean
    ): Long = get(swatchName, primaryColorTone(isDarkScheme))!!

    fun primaryContentColor(
        swatchName: String,
        isDarkScheme: Boolean
    ): Long = get(swatchName, primaryContentColorTone(isDarkScheme))!!

    fun gradientBackgroundColor(
        swatchName: String,
        isDarkScheme: Boolean
    ): Long = setAlphaComponent(get(swatchName, gradientBackgroundColorTone(isDarkScheme))!!, DesignTokens.Content.GradientBackgroundOpacity)

    fun primaryColorTone(isDarkScheme: Boolean): Int = if (isDarkScheme) 400 else 500

    fun primaryContentColorTone(isDarkScheme: Boolean): Int = if (isDarkScheme) 100 else 900

    fun gradientBackgroundColorTone(isDarkScheme: Boolean): Int = if (isDarkScheme) 50 else 50
}
