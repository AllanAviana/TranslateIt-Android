package com.example.translateit_android.data

data class GameUiState(
    val currentWord: String = "",
    val answer: String = "",
    val score: Int = 0,
    val isGameOver: Boolean = false,
    val options: List<String> = listOf(),
)
