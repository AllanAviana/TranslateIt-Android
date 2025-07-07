package com.example.translateit_android.presentation.screen.home.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.translateit_android.ui.theme.pottaOne
import androidx.compose.material3.Text

@Composable
fun BoxScope.TopTexts() {
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
            modifier = Modifier.padding(top = 32.dp)
        )

        Text(
            text = "Bem-vindo!",
            fontSize = 28.sp,
            color = Color(0xFF053406),
            fontFamily = pottaOne,
            modifier = Modifier.padding(top = 40.dp)
        )

        Text(
            text = "Adivinhe a traducao correta\nda palavra em ingles e ganhe\npontos!",
            fontSize = 20.sp,
            color = Color(0xFF71BD6A),
            fontFamily = pottaOne,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}
