package com.itunes_search.design

data class TextStyle(
    val fontWeight: FontWeight = FontWeight.Normal,
    val fontSize: Double,
    val lineHeight: Double? = null,
    val letterSpacing: Double = 0.0
)
