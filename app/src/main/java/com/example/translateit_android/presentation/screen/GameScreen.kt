package com.example.translateit_android.presentation.screen

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.translateit_android.presentation.viewmodel.GameViewModel
import com.example.translateit_android.ui.theme.lalezarRegular
import com.example.translateit_android.ui.theme.pottaOne

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
                    text = "Score: ${uiState.value.score}",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontFamily = pottaOne
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f)
                    .drawBehind {
                        val shadowColor = Color(0x40000000)
                        val cornerRadius = 15.dp.toPx()
                        val blurPx = 4.dp.toPx()
                        val offsetY = 4.dp.toPx()
                        val path = Path().apply {
                            addRoundRect(
                                RoundRect(
                                    rect = Rect(
                                        left = 0f,
                                        top = offsetY,
                                        right = size.width,
                                        bottom = size.height + offsetY
                                    ),
                                    cornerRadius = CornerRadius(cornerRadius)
                                )
                            )
                        }

                        drawIntoCanvas { canvas ->
                            val composePaint = Paint().apply {
                                color = shadowColor
                            }
                            val frameworkPaint = composePaint.asFrameworkPaint()
                            frameworkPaint.maskFilter = BlurMaskFilter(blurPx, BlurMaskFilter.Blur.NORMAL)
                            canvas.drawOutline(
                                outline = Outline.Generic(path),
                                paint = composePaint
                            )
                        }
                    }
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(0xFF09520c))
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = uiState.value.currentWord,
                    fontSize = 64.sp,
                    color = Color.White,
                    fontFamily = lalezarRegular,
                    modifier = Modifier.align(Alignment.Center)
                )
            }


        }

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
                uiState.value.options.chunked(2).forEach { word ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        Box(
                            modifier = Modifier
                                .width(165.dp)
                                .height(62.dp)
                                .drawBehind {
                                    val shadowColor = Color(0x40000000)
                                    val cornerRadius = 10.dp.toPx()
                                    val blurPx = 4.dp.toPx()
                                    val offsetY = 4.dp.toPx()
                                    val path = Path().apply {
                                        addRoundRect(
                                            RoundRect(
                                                rect = Rect(
                                                    left = 0f,
                                                    top = offsetY,
                                                    right = size.width,
                                                    bottom = size.height + offsetY
                                                ),
                                                cornerRadius = CornerRadius(cornerRadius)
                                            )
                                        )
                                    }

                                    drawIntoCanvas { canvas ->
                                        val composePaint = Paint().apply {
                                            color = shadowColor
                                        }
                                        val frameworkPaint = composePaint.asFrameworkPaint()
                                        frameworkPaint.maskFilter = BlurMaskFilter(blurPx, BlurMaskFilter.Blur.NORMAL)
                                        canvas.drawOutline(
                                            outline = Outline.Generic(path),
                                            paint = composePaint
                                        )
                                    }
                                }
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color(0xFF053406))
                                .clickable {
                                    gameViewModel.result(word[0])
                                }
                        ) {
                            Text(
                                text = word[0],
                                fontSize = 28.sp,
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
                                .drawBehind {
                                    val shadowColor = Color(0x40000000)
                                    val cornerRadius = 10.dp.toPx()
                                    val blurPx = 4.dp.toPx()
                                    val offsetY = 4.dp.toPx()
                                    val path = Path().apply {
                                        addRoundRect(
                                            RoundRect(
                                                rect = Rect(
                                                    left = 0f,
                                                    top = offsetY,
                                                    right = size.width,
                                                    bottom = size.height + offsetY
                                                ),
                                                cornerRadius = CornerRadius(cornerRadius)
                                            )
                                        )
                                    }

                                    drawIntoCanvas { canvas ->
                                        val composePaint = Paint().apply {
                                            color = shadowColor
                                        }
                                        val frameworkPaint = composePaint.asFrameworkPaint()
                                        frameworkPaint.maskFilter = BlurMaskFilter(blurPx, BlurMaskFilter.Blur.NORMAL)
                                        canvas.drawOutline(
                                            outline = Outline.Generic(path),
                                            paint = composePaint
                                        )
                                    }
                                }
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color(0xFF053406))
                                .clickable {
                                    gameViewModel.result(word[1])
                                }
                        ) {
                            Text(
                                text = word[1],
                                fontSize = 28.sp,
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