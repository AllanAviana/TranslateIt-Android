package com.example.translateit_android.presentation.screen.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.translateit_android.presentation.screen.game.components.GameHeader
import com.example.translateit_android.presentation.screen.game.components.GameOptions
import com.example.translateit_android.presentation.screen.game.components.GameWordDisplay
import com.example.translateit_android.presentation.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavHostController, gameViewModel: GameViewModel) {
    val uiState = gameViewModel.uiState.collectAsState()

    LaunchedEffect(uiState.value.isGameOver) {
        if (uiState.value.isGameOver) {
            navController.navigate("result_screen")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GameHeader()
        GameWordDisplay(uiState.value)
        GameOptions(uiState.value.options, gameViewModel)
    }
}