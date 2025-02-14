package com.itunes_search.design

object DesignTokens {

    object Content {
        const val MutedContentOpacity = 0.40
        const val ContentHeight = 200

        const val GradientBackgroundOpacity = 0.75
        const val GradientBackgroundSizeScale = 0.9f

        const val DisabledContainerOpacity = 0.12 * 2.0
        const val DisabledContentOpacity = 0.38 * 1.5

        const val DividerThickness = 1.0
    }

    object Image {
        val contentImageHeight = 100.0
        val contentDetailsImageHeight = 300.0
        val contentTrackImageHeight = 50.0
    }

    object Icon {
        // Icons
        const val iconSizeXs = 12
        const val iconSizeSm = 16
        const val iconSizeMd = 24
        const val iconSizeLg = 32
        const val iconSizeXl = 40
        const val iconSizeXxl = 48
    }

    object CornerRadius {
        // https://m3.material.io/styles/shape/shape-scale-tokens
        // https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:compose/material3/material3/src/commonMain/kotlin/androidx/compose/material3/tokens/ShapeTokens.kt
        val None = 0.0
        val Xs = 4.0
        val Sm = 8.0
        val Md = 12.0
        val Lg = 16.0
        val Xl = 28.0
        val Xxl = 40.0

        fun sized(sizePreset: SizePreset) =
            when (sizePreset) {
                SizePreset.Xs -> Xs
                SizePreset.Sm -> Sm
                SizePreset.Md -> Md
                SizePreset.Lg -> Lg
                SizePreset.Xl -> Xl
                SizePreset.Xxl -> Xxl
                is SizePreset.Custom -> sizePreset.value
            }
    }

    object Spacing {
        val None = 0.0
        val Min = 2.0

        val vXs = 4.0
        val vSm = 8.0
        val vMd = 12.0
        val vLg = 16.0
        val vXl = 20.0
        val vXxl = 24.0

        fun v(sizePreset: SizePreset): Double =
            when (sizePreset) {
                SizePreset.Xs -> vXs
                SizePreset.Sm -> vSm
                SizePreset.Md -> vMd
                SizePreset.Lg -> vLg
                SizePreset.Xl -> vXl
                SizePreset.Xxl -> vXxl
                is SizePreset.Custom -> sizePreset.value
            }

        val hXs = 4.0
        val hSm = 10.0
        val hMd = 16.0
        val hLg = 20.0
        val hXl = 24.0
        val hXxl = 32.0

        fun h(sizePreset: SizePreset): Double =
            when (sizePreset) {
                SizePreset.Xs -> hXs
                SizePreset.Sm -> hSm
                SizePreset.Md -> hMd
                SizePreset.Lg -> hLg
                SizePreset.Xl -> hXl
                SizePreset.Xxl -> hXxl
                is SizePreset.Custom -> sizePreset.value
            }
    }
}