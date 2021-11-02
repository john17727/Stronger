package com.github.john17727.stronger.presentation.navigation

sealed class Screen(val route: String) {
    object Login : Screen("Login")
}
