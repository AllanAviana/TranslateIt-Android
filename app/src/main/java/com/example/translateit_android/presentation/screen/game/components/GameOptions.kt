package com.example.translateit_android.presentation.screen.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.translateit_android.presentation.viewmodel.GameViewModel

@Composable
fun GameOptions(options: List<String>, gameViewModel: GameViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight()
            .padding(top = 64.dp)
            .clip(shape = RoundedCornerShape(3.dp))
            .background(color = Color(0xFF387D32)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.05f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.5f),
                            Color.Transparent.copy()
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            options.chunked(2).forEach { word ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    OptionBox(word[0]) { gameViewModel.result(word[0]) }
                    OptionBox(word[1]) { gameViewModel.result(word[1]) }
                }
            }
        }
    }
}