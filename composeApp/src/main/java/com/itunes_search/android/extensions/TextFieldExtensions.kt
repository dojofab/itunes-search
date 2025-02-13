@file:Suppress("ktlint:standard:filename")

package com.itunes_search.android.extensions

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TextFieldDefaults.outlinedThemeColors(): TextFieldColors =
    colors(
        focusedIndicatorColor = MaterialTheme.colorScheme.primary,
        unfocusedIndicatorColor = Color.Transparent,
        focusedContainerColor = MaterialTheme.colorScheme.surface,
    )

