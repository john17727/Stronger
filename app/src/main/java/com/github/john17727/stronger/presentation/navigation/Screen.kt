package com.github.john17727.stronger.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val imageVector: ImageVector? = null) {
    object Login : Screen("Login", "Login")
    object Activity : Screen("Activity", "Activity", Icons.Rounded.Dashboard)
    object Workout : Screen("Workout", "Workout", Icons.Rounded.FitnessCenter)
    object Search : Screen("Exercises", "Exercises", Icons.Rounded.Search)
    object Settings: Screen("Settings", "Settings", Icons.Rounded.Settings)
}
