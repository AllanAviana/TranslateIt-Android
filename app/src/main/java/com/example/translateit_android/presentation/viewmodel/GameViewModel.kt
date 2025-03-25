package com.example.translateit_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.translateit_android.R
import com.example.translateit_android.data.GameUiState
import com.example.translateit_android.data.ResultUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState = _uiState.asStateFlow()

    private val _resultUiState = MutableStateFlow(ResultUiState())
    val resultUiState = _resultUiState.asStateFlow()

    val englishToPortugueseMap = mapOf(
        "apple" to "maçã",
        "house" to "casa",
        "book" to "livro",
        "car" to "carro",
        "water" to "água",
        "food" to "comida",
        "love" to "amor",
        "friend" to "amigo",
        "family" to "família",
        "dog" to "cachorro",
        "cat" to "gato",
        "computer" to "computador",
        "phone" to "telefone",
        "music" to "música",
        "sun" to "sol",
        "moon" to "lua",
        "star" to "estrela",
        "sky" to "céu",
        "earth" to "terra",
        "fire" to "fogo",
        "tree" to "árvore",
        "flower" to "flor",
        "river" to "rio",
        "mountain" to "montanha",
        "sea" to "mar",
        "rain" to "chuva",
        "snow" to "neve",
        "wind" to "vento",
        "child" to "criança",
        "school" to "escola",
        "teacher" to "professor",
        "student" to "estudante",
        "work" to "trabalho",
        "money" to "dinheiro",
        "time" to "tempo",
        "day" to "dia",
        "night" to "noite",
        "morning" to "manhã",
        "evening" to "noite",
        "happy" to "feliz",
        "sad" to "triste",
        "big" to "grande",
        "small" to "pequeno",
        "fast" to "rápido",
        "slow" to "devagar",
        "new" to "novo",
        "old" to "velho",
        "clean" to "limpo",
        "dirty" to "sujo",
        "hot" to "quente"
    )

    init {
        randomWord()
    }

    private fun randomWord(){
        val randomWord = englishToPortugueseMap.keys.random()
        val options = englishToPortugueseMap.values
            .shuffled()
            .filter { it != englishToPortugueseMap[randomWord] }
            .take(3) + englishToPortugueseMap[randomWord]!!

        _uiState.value = _uiState.value.copy(
            currentWord = randomWord,
            answer = englishToPortugueseMap[randomWord]!!,
            options = options.shuffled()
        )
        Log.d("GameViewModel", "Random word: ${_uiState.value}")
    }

    fun result(word: String){

        if(word == _uiState.value.answer){
            _uiState.value = _uiState.value.copy(
                score = _uiState.value.score + 10
            )
            randomWord()
        }else{
            resultGame(_uiState.value.score)
            _uiState.value = _uiState.value.copy(
                isGameOver = true
            )
        }
    }

    private fun resultGame(score: Int){
        if(score >= 30){
            _resultUiState.value = _resultUiState.value.copy(
                word = "Parabéns!",
                sentence = "Voce acertou muitas\nquestoes!",
                image = R.drawable.happyimage
            )
        }else{
            _resultUiState.value = _resultUiState.value.copy(
                word = "Que pena!",
                sentence = "Voce acertou poucas\nquestões...",
                image = R.drawable.badimage
            )
        }
    }

    fun resetGame(){
        _uiState.value = GameUiState()
        randomWord()
    }


}