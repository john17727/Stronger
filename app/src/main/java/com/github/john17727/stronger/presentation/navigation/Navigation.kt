package com.github.john17727.stronger.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.john17727.stronger.presentation.activity.ActivityScreen
import com.github.john17727.stronger.presentation.auth.AuthScreen
import com.github.john17727.stronger.presentation.search.SearchScreen
import com.github.john17727.stronger.presentation.settings.SettingsScreen
import com.github.john17727.stronger.presentation.workout.WorkoutScreen

@ExperimentalComposeUiApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            AuthScreen(navController = navController)
        }
        composable(Screen.Activity.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.Workout.route) {
            WorkoutScreen(navController = navController)
        }
        composable(Screen.Search.route) {
            SearchScreen(navController = navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}