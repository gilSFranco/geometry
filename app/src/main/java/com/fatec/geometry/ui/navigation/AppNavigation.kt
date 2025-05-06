package com.fatec.geometry.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fatec.geometry.ui.screens.Home

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()

    NavHost(
        navController = navigationController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            Home(
                navigationController = navigationController
            )
        }

        composable(
            route = Screen.Result.routeWithArgument,
            arguments = Screen.Result.arguments
        ) { backStackEntry ->
            val result = backStackEntry.arguments?.getString(
                Screen.Result.RESULT_ARGUMENT
            ) ?: ""
        }
    }
}