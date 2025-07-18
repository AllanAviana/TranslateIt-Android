package com.example.translateit_android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.translateit_android.presentation.screen.game.GameScreen
import com.example.translateit_android.presentation.screen.home.HomeScreen
import com.example.translateit_android.presentation.screen.result.ResultScreen
import com.example.translateit_android.presentation.viewmodel.GameViewModel

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()
    val gameViewModel: GameViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = AppNavigationRoute.HomeScreen.route){

        composable(route = AppNavigationRoute.HomeScreen.route){
            HomeScreen(navController)
        }

        composable(route = AppNavigationRoute.GameScreen.route){
            GameScreen(navController, gameViewModel)
        }

        composable(route = AppNavigationRoute.ResultScreen.route){
            ResultScreen(gameViewModel, navController)
        }
    }
}