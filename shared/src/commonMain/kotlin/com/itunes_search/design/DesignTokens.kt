package com.itunes_search.design

object DesignTokens {

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