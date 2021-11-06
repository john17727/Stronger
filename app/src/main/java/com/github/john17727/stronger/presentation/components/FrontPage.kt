package com.github.john17727.stronger.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.github.john17727.stronger.presentation.navigation.Screen

@Composable
fun FrontPageScaffold(navController: NavController, content: @Composable () -> Unit) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        content()
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navigationItems = listOf(
        Screen.Activity,
        Screen.Workout,
        Screen.Search,
        Screen.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = 0.dp
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
                onClick = { navController.navigate(navItem.route) },
                unselectedContentColor = MaterialTheme.colors.onBackground,
                selectedContentColor = MaterialTheme.colors.onPrimary
            )
        }
    }
}