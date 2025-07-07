package com.example.translateit_android.presentation.screen.home.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.BottomSection(onSlideComplete: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.4f)
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .background(color = Color(0xFFCBFFC7)),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SlideToPlayButton(
            modifier = Modifier.padding(bottom = 72.dp),
            onSlideComplete = onSlideComplete
        )
    }
}
