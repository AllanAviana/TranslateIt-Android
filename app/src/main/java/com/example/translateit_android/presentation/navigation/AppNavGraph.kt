package com.example.translateit_android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.translateit_android.presentation.screen.GameScreen
import com.example.translateit_android.presentation.screen.HomeScreen

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppNavigationRoute.HomeScreen.route){

        composable(route = AppNavigationRoute.HomeScreen.route){
            HomeScreen(navController)
        }

        composable(route = AppNavigationRoute.GameScreen.route){
            GameScreen(navController)
        }
    }

}