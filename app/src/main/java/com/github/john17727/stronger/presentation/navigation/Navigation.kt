package com.github.john17727.stronger.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
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
fun Navigation(navController: NavHostController) {
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

@Composable
fun BottomNavigationBar(
    navController: NavController,
    navigationItems: List<Screen>,
    currentRoute: String?,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = 0.dp,
        modifier = modifier
    ) {
        navigationItems.map { navItem ->
            BottomNavigationItem(
                icon = {
                    navItem.imageVector?.let {
                        Surface(
                            color = if (currentRoute == navItem.route) MaterialTheme.colors.primary else MaterialTheme.colors.background,
                            shape = RoundedCornerShape(16.dp),
                            elevation = 0.dp
                        ) {
                            Icon(
                                imageVector = it,
                                contentDescription = navItem.title,
                                modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
                            )
                        }
                    }
                },
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                    }
                },
                unselectedContentColor = MaterialTheme.colors.onBackground,
                selectedContentColor = MaterialTheme.colors.onPrimary
            )
        }
    }
}