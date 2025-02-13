package com.itunes_search.android.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.itunes_search.design.DesignTokens

object ShapeTokens {
    // https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:compose/material3/material3/src/commonMain/kotlin/androidx/compose/material3/tokens/ShapeTokens.kt
    val CornerNone = RectangleShape
    val CornerXs = allCornersShape(DesignTokens.CornerRadius.Xs)
    val CornerTopXs = topCornerShape(DesignTokens.CornerRadius.Xs)
    val CornerSm = allCornersShape(DesignTokens.CornerRadius.Sm)
    val CornerMd = allCornersShape(DesignTokens.CornerRadius.Md)
    val CornerTopMd = topCornerShape(DesignTokens.CornerRadius.Md)
    val CornerEndMd = endCornerShape(DesignTokens.CornerRadius.Md)
    val CornerLg = allCornersShape(DesignTokens.CornerRadius.Lg)
    val CornerTopLg = topCornerShape(DesignTokens.CornerRadius.Lg)
    val CornerEndLg = endCornerShape(DesignTokens.CornerRadius.Lg)
    val CornerXl = allCornersShape(DesignTokens.CornerRadius.Xl)
    val CornerTopXl = topCornerShape(DesignTokens.CornerRadius.Xl)
    val CornerXxl = allCornersShape(DesignTokens.CornerRadius.Xxl)
    val CornerFull = CircleShape
    val TextFieldShape = allCornersShape(DesignTokens.CornerRadius.Md)

    private fun allCornersShape(radius: Double) = RoundedCornerShape(radius.dp)

    private fun topCornerShape(radius: Double) = RoundedCornerShape(topStart = radius.dp, topEnd = radius.dp)

    private fun endCornerShape(radius: Double) = RoundedCornerShape(topEnd = radius.dp, bottomEnd = radius.dp)
}
