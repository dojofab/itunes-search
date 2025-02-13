package com.itunes_search.android.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.itunes_search.android.R
import com.itunes_search.android.extensions.themePaddingV
import com.itunes_search.android.extensions.toColor
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.design.ColorTokens

@Composable
fun ItemView(
    @StringRes label: Int,
    value: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(label),
            color = ColorTokens.onBackgroundMuted.toColor(),
            style = MaterialTheme.typography.bodySmall
        )

        value()
    }
}

@Preview
@Composable
private fun ItemViewPreview() {
    AppTheme {
        ItemView(
            label = R.string.album,
            value = {
                Text("Album")
            }
        )
    }
}