package com.example.translateit_android.presentation.screen.home.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.compose.ui.res.painterResource
import com.example.translateit_android.R

@Composable
fun BoxScope.AnimatedImage(offsetX: Dp) {
    Image(
        painter = painterResource(id = R.drawable.firstimage),
        contentDescription = "First Image",
        modifier = Modifier
            .fillMaxSize(0.8f)
            .align(Alignment.Center)
            .zIndex(1f)
            .padding(bottom = 80.dp)
            .offset(x = offsetX)
    )
}
