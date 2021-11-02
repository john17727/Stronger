package com.github.john17727.stronger.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.john17727.stronger.R
import com.github.john17727.stronger.presentation.components.ElevatedOutlinedTextField
import com.github.john17727.stronger.presentation.components.ElevatedPasswordTextField
import com.github.john17727.stronger.presentation.components.TextToggleButton

@ExperimentalComposeUiApi
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
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
            val focusRequester = remember { FocusRequester() }
            val keyboardController = LocalSoftwareKeyboardController.current
            ElevatedOutlinedTextField(
                value = viewModel.usernameText.value,
                onValueChange = {
                    viewModel.setUsernameText(it)
                },
                placeholder = { Text("Username/Email") },
                focusedElevation = 6.dp,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusRequester.requestFocus() }),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            ElevatedPasswordTextField(
                value = viewModel.passwordText.value,
                onValueChange = {
                    viewModel.setPasswordText(it)
                },
                placeholder = { Text("Password") },
                focusedElevation = 6.dp,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                visibleIcon = Icons.Rounded.Visibility,
                invisibleIcon = Icons.Rounded.VisibilityOff
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
