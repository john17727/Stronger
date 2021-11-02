package com.github.john17727.stronger.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.john17727.stronger.R
import com.github.john17727.stronger.presentation.components.TextToggleButton
import com.github.john17727.stronger.presentation.ui.theme.StrongerTheme

@Composable
fun LoginScreen(navController: NavController) {
    Content()
}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.app_name_caps),
                style = MaterialTheme.typography.h3,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /*TODO*/ },
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
            ) {
                Icon(
                    Icons.Rounded.ArrowForwardIos,
                    contentDescription = "Submit",
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
                )
            }
        }

        Surface(
            color = MaterialTheme.colors.surface,
            modifier = Modifier.align(Alignment.BottomCenter),
            shape = RoundedCornerShape(20.dp)
        ) {
            var isPrimaryButtonSelected by remember {
                mutableStateOf(true)
            }
            Row(modifier = Modifier.padding(4.dp)) {
                TextToggleButton(
                    isSelected = isPrimaryButtonSelected,
                    onClick = {
                        isPrimaryButtonSelected = it
                    }
                ) {
                    Text(
                        stringResource(R.string.login),
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = if (isPrimaryButtonSelected) {
                            MaterialTheme.colors.onPrimary
                        } else {
                            MaterialTheme.colors.onSurface
                        }
                    )
                }
                TextToggleButton(
                    isSelected = !isPrimaryButtonSelected,
                    onClick = {
                        isPrimaryButtonSelected = !it
                    }
                ) {
                    Text(
                        text = stringResource(R.string.register),
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = if (!isPrimaryButtonSelected) {
                            MaterialTheme.colors.onPrimary
                        } else {
                            MaterialTheme.colors.onSurface
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    StrongerTheme {
        Content()
    }
}