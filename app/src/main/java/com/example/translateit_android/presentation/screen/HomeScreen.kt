package com.example.translateit_android.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.translateit_android.R
import com.example.translateit_android.ui.theme.pottaOne

@Composable
fun HomeScreen(navController: NavHostController) {
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
                text = "Bem-vindo!",
                fontSize = 28.sp,
                color = Color(0xFF053406),
                fontFamily = pottaOne,
                modifier = Modifier
                    .padding(top = 40.dp)
            )

            Text(
                text = "Adivinhe a traducao correta\nda palavra em ingles e ganhe\npontos!",
                fontSize = 20.sp,
                color = Color(0xFF71BD6A),
                fontFamily = pottaOne,
                modifier = Modifier
                    .padding(top = 20.dp)
            )

        }

        Image(
            painter = painterResource(id = R.drawable.firstimage),
            contentDescription = "First Image",
            modifier = Modifier
                .fillMaxSize(0.8f)
                .align(Alignment.Center)
                .zIndex(1f)
                .padding(bottom  = 80.dp)
            )

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
                modifier = Modifier
                    .padding(bottom = 72.dp)
            ) {
                navController.navigate("game_screen")
            }
        }
    }
}

@Composable
fun SlideToPlayButton(
    modifier: Modifier = Modifier,
    onSlideComplete: () -> Unit
) {
    val buttonHeight = 80.dp

    var offsetX by remember { mutableStateOf(0f) }

    val localDensity = LocalDensity.current

    val totalWidth = 360.dp

    val maxOffsetPx = with(localDensity) {
        (totalWidth - buttonHeight).toPx()
    }

    Box(
        modifier = modifier
            .width(totalWidth)
            .height(buttonHeight)
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    color = Color(0xFF387D32).copy(alpha = 0.2f),
                    shape = RoundedCornerShape(50)
                )
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(8.dp)
                .background(
                    color = Color(0xFF387D32).copy(alpha = 0.2f),
                    shape = RoundedCornerShape(50)
                )
        )

        Text(
            text = "Jogar",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )

        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset { IntOffset(x = 0, y = 0) }
                .width(with(localDensity) { offsetX.toDp() } + buttonHeight)
                .height(buttonHeight)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFF387D32))
        )

        Box(
            modifier = Modifier

                .offset { IntOffset(x = offsetX.toInt(), y = 0) }
                .size(buttonHeight)
                .clip(CircleShape)
                .background(Color(0xFF387D32))
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF09520C))
            )
            Icon(
                painter = painterResource(id = R.drawable.chevronduplo),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(32.dp)
            )
        }
                Box(
            modifier = Modifier
                .matchParentSize()

                .pointerInput(Unit) {
                    detectDragGestures(
                        onDrag = { change, dragAmount ->
                            change.consume()
                            val newOffset = offsetX + dragAmount.x
                            offsetX = newOffset.coerceIn(0f, maxOffsetPx)
                        },
                        onDragEnd = {
                            if (offsetX > maxOffsetPx / 2) {
                                onSlideComplete()
                            } else {
                                offsetX = 0f
                            }
                        }
                    )
                }
        )
    }
}