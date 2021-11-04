package com.github.john17727.stronger.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject
constructor() : ViewModel() {

    private val _email = mutableStateOf("")
    val emailText: State<String> = _email

    private val _password = mutableStateOf("")
    val passwordText: State<String> = _password

    private val _firstname = mutableStateOf("")
    val firstNameText: State<String> = _firstname

    private val _lastname = mutableStateOf("")
    val lastNameText: State<String> = _lastname

    fun setEmailText(username: String) {
        _email.value = username
    }

    fun setPasswordText(password: String) {
        _password.value = password
    }

    fun setFirstNameText(password: String) {
        _firstname.value = password
    }

    fun setLastNameText(password: String) {
        _lastname.value = password
    }
}