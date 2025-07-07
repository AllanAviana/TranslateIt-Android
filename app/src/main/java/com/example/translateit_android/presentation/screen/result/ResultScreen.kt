package com.example.translateit_android.presentation.screen.result

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.translateit_android.presentation.viewmodel.GameViewModel
import com.example.translateit_android.ui.theme.pottaOne

@Composable
fun ResultScreen(gameViewModel: GameViewModel, navController: NavHostController) {

    val uiState = gameViewModel.resultUiState.collectAsState()

    var startAnimation by remember { mutableStateOf(false) }

    val alpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )

    LaunchedEffect(Unit) {
        startAnimation = true
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.61f)
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .background(color = Color(0xFFE0FFDD))
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "TranslateIt",
                fontSize = 40.sp,
                color = Color(0xFF053406),
                fontFamily = pottaOne,
                modifier = Modifier
                    .padding(top = 32.dp)

            )

            Text(
                text = uiState.value.word,
                fontSize = 28.sp,
                color = Color(0xFF053406),
                fontFamily = pottaOne,
                modifier = Modifier
                    .padding(top = 40.dp)
            )

            Text(
                text = uiState.value.sentence,
                fontSize = 20.sp,
                color = Color(0xFF71BD6A),
                fontFamily = pottaOne,
                modifier = Modifier
                    .padding(top = 20.dp)
            )

        }

        Image(
            painter = painterResource(id = uiState.value.image),
            contentDescription = "First Image",
            modifier = Modifier
                .fillMaxSize(0.6f)
                .align(Alignment.Center)
                .zIndex(1f)
                .padding(bottom  =40.dp)
                .alpha(alpha)
        )

        Column(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(color = Color(0xFF91DE8A)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = {
                    gameViewModel.resetGame()
                    navController.navigate("Home_screen")
                          },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(top = 140.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF053406))
            ) {
                Text(
                    text = "Voltar",
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }
        }
    }
}