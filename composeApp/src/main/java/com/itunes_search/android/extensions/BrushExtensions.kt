
@file:Suppress("ktlint:standard:filename")

package com.itunes_search.android.extensions

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Brush.Companion.appBackgroundGradient(
    highlightColor: Color,
    baseColor: Color,
    size: Float = Float.POSITIVE_INFINITY
): Brush =
    radialGradient(
        colors =
            listOf(
                highlightColor,
                baseColor
            ),
        center = Offset.Zero,
        radius = size
    )

fun sliderAlphaRGBGradient(
    color: Color,
    start: Offset = Offset.Zero,
    end: Offset = Offset.Infinite
): Brush =
    Brush.linearGradient(
        colors =
            listOf(
                Color(color.red, color.green, color.blue, 0f),
                Color(color.red, color.green, color.blue, 1f)
            ),
        start = start,
        end = end
    )
