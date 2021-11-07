package com.github.john17727.stronger.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.john17727.stronger.presentation.navigation.BottomNavigationBar
import com.github.john17727.stronger.presentation.navigation.Navigation
import com.github.john17727.stronger.presentation.navigation.Screen
import com.github.john17727.stronger.presentation.ui.theme.StrongerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            val navigationItems = listOf(
                Screen.Activity,
                Screen.Workout,
                Screen.Search,
                Screen.Settings
            )
            StrongerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Scaffold(
                        bottomBar = {
                            if (navigationItems.contains(navigationItems.find { screen -> screen.route == currentRoute })) {
                                BottomNavigationBar(
                                    navController = navController,
                                    navigationItems = navigationItems,
                                    currentRoute = currentRoute
                                )
                            }
                        }
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}