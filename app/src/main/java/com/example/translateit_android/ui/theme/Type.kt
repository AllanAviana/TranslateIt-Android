package com.example.translateit_android.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.translateit_android.R


val pottaOne = FontFamily(
    Font(R.font.pottaoneregular, FontWeight.Normal)
)

val lalezarRegular = FontFamily(
    Font(R.font.lalezarregular, FontWeight.Normal)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily =  FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = pottaOne,
        fontWeight = FontWeight.Normal
    )
    // Defina outros estilos conforme a necessidade
)