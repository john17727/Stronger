package com.github.john17727.stronger.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ElevatedOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    unfocusedElevation: Dp = 0.dp,
    focusedElevation: Dp = 4.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: ImageVector? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    var isFocused by remember {
        mutableStateOf(false)
    }
    Surface(
        elevation = if (isFocused) focusedElevation else unfocusedElevation,
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.onFocusChanged {
            isFocused = it.isFocused
        }
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            singleLine = true,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            modifier = modifier,
            leadingIcon = leadingIcon?.let {
                {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = "icon",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            },
            trailingIcon = trailingIcon,
            visualTransformation = visualTransformation
        )
    }
}

@Composable
fun ElevatedPasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    unfocusedElevation: Dp = 0.dp,
    focusedElevation: Dp = 4.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    leadingIcon: ImageVector? = null,
    visibleIcon: ImageVector,
    invisibleIcon: ImageVector
) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    ElevatedOutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        unfocusedElevation = unfocusedElevation,
        focusedElevation = focusedElevation,
        keyboardOptions = keyboardOptions.copy(keyboardType = KeyboardType.Password),
        keyboardActions = keyboardActions,
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {

                Icon(
                    imageVector = if (passwordVisibility) {
                        visibleIcon
                    } else {
                        invisibleIcon
                    },
                    contentDescription = "Password Visibility"
                )
            }
        },
        leadingIcon = leadingIcon
    )
}