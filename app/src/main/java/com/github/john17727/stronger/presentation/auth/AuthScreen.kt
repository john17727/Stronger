package com.github.john17727.stronger.presentation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
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
import com.github.john17727.stronger.presentation.navigation.Screen

@ExperimentalComposeUiApi
@Composable
fun AuthScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var isPrimaryButtonSelected by remember {
            mutableStateOf(true)
        }

        if (isPrimaryButtonSelected) {
            LoginScreen(viewModel = viewModel, navController)
        } else {
            RegisterScreen(viewModel = viewModel)
        }


        Surface(
            color = MaterialTheme.colors.surface,
            modifier = Modifier.align(Alignment.BottomCenter),
            shape = RoundedCornerShape(20.dp)
        ) {
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
                            MaterialTheme.colors.onBackground
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
                            MaterialTheme.colors.onBackground
                        } else {
                            MaterialTheme.colors.onSurface
                        }
                    )
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val focusRequester = remember { FocusRequester() }
        val keyboardController = LocalSoftwareKeyboardController.current
        Text(
            text = stringResource(id = R.string.login),
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(8.dp))
        ElevatedOutlinedTextField(
            value = viewModel.emailText.value,
            onValueChange = {
                viewModel.setEmailText(it)
            },
            placeholder = { Text("Email") },
            focusedElevation = 6.dp,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusRequester.requestFocus() }),
            leadingIcon = Icons.Rounded.Email,
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
            invisibleIcon = Icons.Rounded.VisibilityOff,
            leadingIcon = Icons.Rounded.VpnKey
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate(Screen.Activity.route) },
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
        ) {
            Icon(
                Icons.Rounded.ArrowForwardIos,
                contentDescription = "Submit",
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
            )
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun RegisterScreen(viewModel: LoginViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val focusRequester = remember { FocusRequester() }
        val keyboardController = LocalSoftwareKeyboardController.current
        Text(
            text = stringResource(id = R.string.register),
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(8.dp))
        ElevatedOutlinedTextField(
            value = viewModel.firstNameText.value,
            onValueChange = {
                viewModel.setFirstNameText(it)
            },
            placeholder = { Text("First Name") },
            focusedElevation = 6.dp,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusRequester.requestFocus() }),
            leadingIcon = Icons.Rounded.Person,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        ElevatedOutlinedTextField(
            value = viewModel.lastNameText.value,
            onValueChange = {
                viewModel.setLastNameText(it)
            },
            placeholder = { Text("Last Name") },
            focusedElevation = 6.dp,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusRequester.requestFocus() }),
            leadingIcon = Icons.Rounded.People,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        ElevatedOutlinedTextField(
            value = viewModel.emailText.value,
            onValueChange = {
                viewModel.setEmailText(it)
            },
            placeholder = { Text("Email") },
            focusedElevation = 6.dp,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusRequester.requestFocus() }),
            leadingIcon = Icons.Rounded.Email,
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
            leadingIcon = Icons.Rounded.VpnKey,
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
}
