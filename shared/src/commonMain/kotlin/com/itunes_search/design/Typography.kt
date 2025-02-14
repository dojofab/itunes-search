package com.itunes_search.design

// Loosely based on: https://m3.material.io/styles/typography/type-scale-tokens
object Typography {
    val displayLarge =
        TextStyle(
            fontSize = 57.0,
            lineHeight = 64.0
        )

    val displayMedium =
        TextStyle(
            fontSize = 45.0,
            lineHeight = 52.0
        )

    val displaySmall =
        TextStyle(
            fontSize = 36.0,
            lineHeight = 44.0
        )

    val headlineLarge =
        TextStyle(
            fontSize = 32.0,
            lineHeight = 40.0
        )

    val headlineMedium =
        TextStyle(
            fontSize = 28.0,
            lineHeight = 36.0
        )

    val headlineSmall =
        TextStyle(
            fontSize = 24.0,
            lineHeight = 32.0
        )

    val titleLarge =
        TextStyle(
            fontSize = 32.0,
            lineHeight = 40.0
        )

    val titleMedium =
        TextStyle(
            fontSize = 24.0,
            fontWeight = FontWeight.Bold
        )

    val titleSmall =
        TextStyle(
            fontSize = 16.0,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.1
        )

    val bodyLarge =
        TextStyle(
            fontSize = 16.0,
            lineHeight = 24.0,
            fontWeight = FontWeight.Medium
        )

    val bodyMedium =
        TextStyle(
            fontSize = 14.0,
            lineHeight = 22.0
        )

    val bodySmall =
        TextStyle(
            fontSize = 12.0,
            lineHeight = 16.0,
            letterSpacing = 0.4
        )

    val labelLarge =
        TextStyle(
            fontSize = 14.0,
            lineHeight = 20.0,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.1
        )

    val labelMedium =
        TextStyle(
            fontSize = 12.0,
            lineHeight = 16.0,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5
        )

    val labelSmall =
        TextStyle(
            fontSize = 10.0,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5
        )
}
