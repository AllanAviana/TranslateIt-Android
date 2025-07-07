package com.example.translateit_android.presentation.screen.home

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.translateit_android.R
import com.example.translateit_android.presentation.screen.home.components.AnimatedImage
import com.example.translateit_android.presentation.screen.home.components.BottomSection
import com.example.translateit_android.presentation.screen.home.components.TopTexts
import com.example.translateit_android.ui.theme.pottaOne

@Composable
fun HomeScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }

    val offsetX by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else (-400).dp,
        animationSpec = tween(durationMillis = 2000)
    )

    LaunchedEffect(Unit) { startAnimation = true }

    Box(modifier = Modifier.fillMaxSize()) {
        TopTexts()
        AnimatedImage(offsetX)
        BottomSection { navController.navigate("game_screen") }
    }
}

