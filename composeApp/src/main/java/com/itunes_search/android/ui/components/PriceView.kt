package com.itunes_search.android.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.itunes_search.android.extensions.themePaddingH
import com.itunes_search.android.extensions.themePaddingV
import com.itunes_search.android.extensions.toColor
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.android.ui.theme.ShapeTokens
import com.itunes_search.design.ColorTokens
import com.itunes_search.design.SizePreset

@Composable
fun PriceView(
    price: String,
    currency: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = Color.Red,
        shape = ShapeTokens.CornerMd
    ){
        Text(
            modifier = Modifier
                .themePaddingV(SizePreset.Xs)
                .themePaddingH(SizePreset.Lg),
            text = "$price $currency",
            color = ColorTokens.onBackground.toColor(),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
private fun PriceViewPreview() {
    AppTheme {
        PriceView(
            price = "12",
            currency = "USD"
        )
    }
}