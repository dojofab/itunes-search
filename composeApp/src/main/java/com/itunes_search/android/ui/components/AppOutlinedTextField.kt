package com.itunes_search.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.itunes_search.android.R
import com.itunes_search.android.extensions.outlinedThemeColors
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.android.ui.theme.ShapeTokens.TextFieldShape

@Composable
fun AppOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    placeholder: (@Composable () -> Unit)? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldShape,
    colors: TextFieldColors = TextFieldDefaults.outlinedThemeColors()
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        label = null,
        readOnly = readOnly,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
        modifier = modifier
    )
}

@Composable
fun AppOutlinedSearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    showClearButton: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    placeholder: (@Composable () -> Unit)? = null,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions? = null,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldShape,
    colors: TextFieldColors = TextFieldDefaults.outlinedThemeColors()
) {
    val searchOptions =
        remember {
            KeyboardOptions.Default.copy(imeAction = ImeAction.Search)
        }
    val trailingIcon: (@Composable () -> Unit)? =
        remember(value.isNotEmpty(), showClearButton) {
            if (value.isNotEmpty() && showClearButton) {
                {
                    Icon(
                        Icons.Default.Clear,
                        contentDescription = null,
                        modifier =
                            Modifier.clickable {
                                onValueChange("")
                            }
                    )
                }
            } else {
                null
            }
        }

    AppOutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        textStyle = textStyle,
        placeholder = placeholder,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        },
        trailingIcon = trailingIcon,
        isError = isError,
        keyboardOptions = keyboardOptions ?: searchOptions,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )
}

@Preview(showBackground = true)
@Composable
fun AppOutlinedTextFieldPreview() {
    AppTheme {
        AppOutlinedTextField("Test", {})
    }
}
