package com.example.translateit_android.presentation.navigation

sealed class AppNavigationRoute(val route: String) {
    object HomeScreen : AppNavigationRoute("home_screen")
    object GameScreen : AppNavigationRoute("game_screen")
}