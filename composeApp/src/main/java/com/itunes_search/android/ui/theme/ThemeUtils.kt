package com.itunes_search.android.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.itunes_search.android.R
import com.itunes_search.android.extensions.toColor
import com.itunes_search.android.extensions.toMaterialStyle
import com.itunes_search.design.Theme

fun Theme.materialColorScheme(): ColorScheme =
    darkColorScheme(
        primary = colors.primary.toColor(),
        onPrimary = colors.onPrimary.toColor(),
        primaryContainer = colors.primaryContainer.toColor(),
        onPrimaryContainer = colors.onPrimaryContainer.toColor(),
        inversePrimary = colors.inversePrimary.toColor(),
        secondary = colors.secondary.toColor(),
        onSecondary = colors.onSecondary.toColor(),
        secondaryContainer = colors.secondaryContainer.toColor(),
        onSecondaryContainer = colors.onSecondaryContainer.toColor(),
        tertiary = colors.tertiary.toColor(),
        onTertiary = colors.onTertiary.toColor(),
        tertiaryContainer = colors.tertiaryContainer.toColor(),
        onTertiaryContainer = colors.onTertiaryContainer.toColor(),
        background = colors.background.toColor(),
        onBackground = colors.onBackground.toColor(),
        surface = colors.surface.toColor(),
        onSurface = colors.onSurface.toColor(),
        surfaceVariant = colors.surfaceVariant.toColor(),
        onSurfaceVariant = colors.onSurfaceVariant.toColor(),
        surfaceTint = colors.surfaceTint.toColor(),
        inverseSurface = colors.inverseSurface.toColor(),
        inverseOnSurface = colors.inverseOnSurface.toColor(),
        error = colors.error.toColor(),
        onError = colors.onError.toColor(),
        errorContainer = colors.errorContainer.toColor(),
        onErrorContainer = colors.onErrorContainer.toColor(),
        outline = colors.outline.toColor()
    )
    /*if (colors.isDarkScheme) {
        darkColorScheme(
            primary = colors.primary.toColor(),
            onPrimary = colors.onPrimary.toColor(),
            primaryContainer = colors.primaryContainer.toColor(),
            onPrimaryContainer = colors.onPrimaryContainer.toColor(),
            inversePrimary = colors.inversePrimary.toColor(),
            secondary = colors.secondary.toColor(),
            onSecondary = colors.onSecondary.toColor(),
            secondaryContainer = colors.secondaryContainer.toColor(),
            onSecondaryContainer = colors.onSecondaryContainer.toColor(),
            tertiary = colors.tertiary.toColor(),
            onTertiary = colors.onTertiary.toColor(),
            tertiaryContainer = colors.tertiaryContainer.toColor(),
            onTertiaryContainer = colors.onTertiaryContainer.toColor(),
            background = colors.background.toColor(),
            onBackground = colors.onBackground.toColor(),
            surface = colors.surface.toColor(),
            onSurface = colors.onSurface.toColor(),
            surfaceVariant = colors.surfaceVariant.toColor(),
            onSurfaceVariant = colors.onSurfaceVariant.toColor(),
            surfaceTint = colors.surfaceTint.toColor(),
            inverseSurface = colors.inverseSurface.toColor(),
            inverseOnSurface = colors.inverseOnSurface.toColor(),
            error = colors.error.toColor(),
            onError = colors.onError.toColor(),
            errorContainer = colors.errorContainer.toColor(),
            onErrorContainer = colors.onErrorContainer.toColor(),
            outline = colors.outline.toColor()
        )
    } else {
        lightColorScheme(
            primary = colors.primary.toColor(),
            onPrimary = colors.onPrimary.toColor(),
            primaryContainer = colors.primaryContainer.toColor(),
            onPrimaryContainer = colors.onPrimaryContainer.toColor(),
            inversePrimary = colors.inversePrimary.toColor(),
            secondary = colors.secondary.toColor(),
            onSecondary = colors.onSecondary.toColor(),
            secondaryContainer = colors.secondaryContainer.toColor(),
            onSecondaryContainer = colors.onSecondaryContainer.toColor(),
            tertiary = colors.tertiary.toColor(),
            onTertiary = colors.onTertiary.toColor(),
            tertiaryContainer = colors.tertiaryContainer.toColor(),
            onTertiaryContainer = colors.onTertiaryContainer.toColor(),
            background = colors.background.toColor(),
            onBackground = colors.onBackground.toColor(),
            surface = colors.surface.toColor(),
            onSurface = colors.onSurface.toColor(),
            surfaceVariant = colors.surfaceVariant.toColor(),
            onSurfaceVariant = colors.onSurfaceVariant.toColor(),
            surfaceTint = colors.surfaceTint.toColor(),
            inverseSurface = colors.inverseSurface.toColor(),
            inverseOnSurface = colors.inverseOnSurface.toColor(),
            error = colors.error.toColor(),
            onError = colors.onError.toColor(),
            errorContainer = colors.errorContainer.toColor(),
            onErrorContainer = colors.onErrorContainer.toColor(),
            outline = colors.outline.toColor()
        )
    }*/

fun Theme.materialTypography(): Typography =
    Typography(
        displayLarge = this.typography.displayLarge.toMaterialStyle(),
        displayMedium = this.typography.displayMedium.toMaterialStyle(),
        displaySmall = this.typography.displaySmall.toMaterialStyle(),
        headlineLarge = this.typography.headlineLarge.toMaterialStyle(),
        headlineMedium = this.typography.headlineMedium.toMaterialStyle(),
        headlineSmall = this.typography.headlineSmall.toMaterialStyle(),
        titleLarge = this.typography.titleLarge.toMaterialStyle(),
        titleMedium = this.typography.titleMedium.toMaterialStyle(),
        titleSmall = this.typography.titleSmall.toMaterialStyle(),
        bodyLarge = this.typography.bodyLarge.toMaterialStyle(),
        bodyMedium = this.typography.bodyMedium.toMaterialStyle(),
        bodySmall = this.typography.bodySmall.toMaterialStyle(),
        labelLarge = this.typography.labelLarge.toMaterialStyle(),
        labelMedium = this.typography.labelMedium.toMaterialStyle(),
        labelSmall = this.typography.labelSmall.toMaterialStyle()
    )

fun Theme.materialShapes(): Shapes = AppShape

val Lato =
    FontFamily(
        Font(R.font.lato_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
        Font(R.font.lato_regular, weight = FontWeight.Medium),
        Font(R.font.lato_black, weight = FontWeight.Black),
        Font(R.font.lato_bold, weight = FontWeight.Bold),
        Font(R.font.lato_light, weight = FontWeight.Light),
        Font(R.font.lato_thin, weight = FontWeight.Thin),
        Font(R.font.lato_bolditalic, weight = FontWeight.Bold, style = FontStyle.Italic),
        Font(R.font.lato_italic, weight = FontWeight.Normal, style = FontStyle.Italic)
    )
