package com.github.john17727.stronger.presentation.activity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.github.john17727.stronger.presentation.components.FrontPageScaffold

@Composable
fun ActivityScreen(navController: NavController) {
    FrontPageScaffold(navController = navController) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "Activity")
        }
    }
}