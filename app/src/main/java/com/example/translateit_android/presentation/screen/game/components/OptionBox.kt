package com.example.translateit_android.presentation.screen.game.components

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import com.example.translateit_android.ui.theme.pottaOne

@Composable
fun OptionBox(text: String, onClick: () -> Unit) {
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
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            fontSize = 28.sp,
            color = Color.White,
            fontFamily = pottaOne,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}