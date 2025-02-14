package com.itunes_search.design.palettes

internal class ColorSwatch(
    name: String,
    vararg toneColors: Pair<Int, Long>
) {
    val name: String
    private val colorTones: MutableMap<Int, Long>

    init {
        this.name = name
        colorTones = mutableMapOf(*toneColors)
    }

    infix fun tone(x: Int): Long? = colorTones[x]

    fun asNamedPair() = name to this
}
