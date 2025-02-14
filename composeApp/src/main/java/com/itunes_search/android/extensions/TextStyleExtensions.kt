
@file:Suppress("ktlint:standard:filename")

package com.itunes_search.android.extensions

import androidx.compose.ui.text.TextStyle as MaterialTextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.itunes_search.android.ui.theme.Lato
import com.itunes_search.design.TextStyle

fun TextStyle.toMaterialStyle(): MaterialTextStyle =
    MaterialTextStyle(
        fontSize = this.fontSize.sp,
        lineHeight = this.lineHeight?.sp ?: TextUnit.Unspecified,
        fontFamily = Lato,
        fontWeight = FontWeight(this.fontWeight.weight),
        letterSpacing = this.letterSpacing.sp
    )
