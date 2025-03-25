package com.example.translateit_android.data

import com.example.translateit_android.R

data class ResultUiState(
    val word: String = "Parabéns!",
    val sentence: String = "Voce acertou muitas\nquestoes!",
    val image: Int = R.drawable.happyimage
)