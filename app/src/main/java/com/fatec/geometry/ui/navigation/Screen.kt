package com.fatec.geometry.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen (
    val route: String
) {
    object Home: Screen(route = "home")
    object Result: Screen(route = "result") {
        const val RESULT_ARGUMENT = "result"
        val routeWithArgument = "$route/{$RESULT_ARGUMENT}"

        val arguments = listOf(
            navArgument(RESULT_ARGUMENT) {
                type = NavType.StringType
            }
        )

        fun createRoute(result: String) = "$route/$result"
    }
}