package com.itunes_search.design

import com.itunes_search.ui.shouldUseDarkOn

object AppColors {
    const val Black = 0xff000000
    const val White = 0xffffffff
    const val LightText = White
    const val DarkText = 0xff242424
    const val DefaultPrimary = 0xfff19C3A
    const val LightSurface = 0xfff9f9f9
    const val DarkSurface = 0xff333333
    const val LightSurfaceVariant = 0xffc4c4c4
    const val DarkSurfaceVariant = 0xff414141
    const val LightBackground = White
    const val DarkBackground = 0xff212121

    fun textColorOn(backgroundColor: Long) =
        if (shouldUseDarkOn(backgroundColor, 0.43)) {
            DarkText
        } else {
            LightText
        }
}
