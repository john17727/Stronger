package com.github.john17727.stronger.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextToggleButton(
    isSelected: Boolean,
    onClick: (Boolean) -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background),
    content: @Composable RowScope.() -> Unit
) {

    if (isSelected) {
        Button(
            onClick = {
                onClick(true)
            },
            shape = RoundedCornerShape(16.dp),
            content = content,
            elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
            colors = colors
        )
    } else {
        TextButton(
            onClick = {
                onClick(true)
            },
            shape = RoundedCornerShape(16.dp),
            content = content,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}