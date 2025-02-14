package com.itunes_search.android.util

import androidx.compose.ui.graphics.Color
import com.itunes_search.android.extensions.toColor

object ColorCache {
    private val map = HashMap<Long, Color>(32)

    operator fun get(colorCode: Long): Color {
        val color = map[colorCode]
        if (color == null) {
            val newColor = colorCode.toColor()
            map[colorCode] = newColor
            return newColor
        }

        return color
    }
}
