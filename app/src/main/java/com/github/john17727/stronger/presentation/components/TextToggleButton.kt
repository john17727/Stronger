package com.github.john17727.stronger.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextToggleButton(
    isSelected: Boolean,
    onClick: (Boolean) -> Unit,
    content: @Composable RowScope.() -> Unit
) {

    if (isSelected) {
        Button(
            onClick = {
                onClick(true)
            },
            shape = RoundedCornerShape(16.dp),
            content = content,
            elevation = ButtonDefaults.elevation(defaultElevation = 4.dp)
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