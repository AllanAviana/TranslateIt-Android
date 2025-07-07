package com.example.translateit_android.presentation.screen.game.components

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.translateit_android.presentation.uistate.GameUiState
import com.example.translateit_android.ui.theme.lalezarRegular
import com.example.translateit_android.ui.theme.pottaOne

@Composable
fun GameWordDisplay(uiState: GameUiState) {
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
                text = "Score: ${uiState.score}",
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
                text = uiState.currentWord,
                fontSize = 64.sp,
                color = Color.White,
                fontFamily = lalezarRegular,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}