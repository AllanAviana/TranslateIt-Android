package com.example.translateit_android.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.translateit_android.ui.theme.lalezarRegular
import com.example.translateit_android.ui.theme.pottaOne

@Composable
fun GameScreen() {
    val list = listOf("Foco", "Fomentar", "Praia", "Casa")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.08f)
                .background(Color(0xFF09520C)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "TranslateIt",
                color = Color.White,
                fontSize = 24.sp,
                fontFamily = pottaOne
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.55f)
                .padding(top = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .fillMaxHeight(0.1f)
                    .clip(shape = RoundedCornerShape(11.dp))
                    .background(Color(0xFF053406))
                    .align(Alignment.TopCenter)
                    .zIndex(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Score: 30",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontFamily = pottaOne
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color(0xFF09520c))
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = "Foster",
                    fontSize = 64.sp,
                    color = Color.White,
                    fontFamily = lalezarRegular,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight()
                .padding(top = 56.dp)
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
                list.chunked(2).forEach { word ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Box(
                            modifier = Modifier
                                .width(165.dp)
                                .height(62.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color(0xFF053406))
                        ) {
                            Text(
                                text = word[0],
                                fontSize = 32.sp,
                                color = Color.White,
                                fontFamily = pottaOne,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .width(165.dp)
                                .height(62.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color(0xFF053406))
                                .align(Alignment.CenterVertically)
                        ) {
                            Text(
                                text = word[1],
                                fontSize = 32.sp,
                                color = Color.White,
                                fontFamily = pottaOne,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }

    }
}