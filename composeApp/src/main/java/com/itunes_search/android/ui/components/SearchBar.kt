package com.itunes_search.android.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.itunes_search.android.R
import com.itunes_search.android.ui.theme.AppTheme

@Composable
fun SearchBar(
    value: String,
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    AppOutlinedSearchTextField(
        modifier = modifier,
        value = value,
        onValueChange = onSearch,
        placeholder = {
            Text(stringResource(R.string.search_placeholder))
        }
    )
}

@Preview
@Composable
private fun SearchBarPreview() {
    AppTheme {
        SearchBar(
            value = "",
            onSearch = {}
        )
    }
}