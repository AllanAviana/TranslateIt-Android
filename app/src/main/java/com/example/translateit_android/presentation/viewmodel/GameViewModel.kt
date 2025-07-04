package com.example.translateit_android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.translateit_android.R
import com.example.translateit_android.data.GameRepository
import com.example.translateit_android.presentation.uistate.GameUiState
import com.example.translateit_android.presentation.uistate.ResultUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val repo: GameRepository
) : ViewModel() {

    /* --------------------- main game state (question, score, etc.) --------------------- */
    private val _uiState = MutableStateFlow(GameUiState())   // mutable inside VM
    val uiState = _uiState.asStateFlow()                     // read-only for the UI

    /* --------------------- end-of-game state (message + image) ------------------------- */
    private val _resultUiState = MutableStateFlow(ResultUiState())
    val resultUiState = _resultUiState.asStateFlow()

    /* Generate the very first question as soon as the VM is created */
    init { randomWord() }

    /** Requests a new question from the repository and updates _uiState */
    private fun randomWord() {
        val (wordEn, answerPt, options) = repo.generateQuestion()

        _uiState.value = _uiState.value.copy(
            currentWord = wordEn,   // English prompt word
            answer      = answerPt, // correct Portuguese translation
            options     = options   // shuffled list of 4 choices
        )
    }

    fun result(word: String) {
        if (word == _uiState.value.answer) {
            _uiState.value = _uiState.value.copy(
                score = _uiState.value.score + 10
            )
            randomWord()                // next round
        } else {
            buildResult(_uiState.value.score)
            _uiState.value = _uiState.value.copy(isGameOver = true)
        }
    }

    /** Builds the ResultUiState based on the final score */
    private fun buildResult(score: Int) {
        val success = score >= 30
        _resultUiState.value = _resultUiState.value.copy(
            word     = if (success) "Parabéns!" else "Que pena!",
            sentence = if (success)
                "Você acertou muitas\nquestões!"
            else
                "Você acertou poucas\nquestões...",
            image    = if (success) R.drawable.happyimage
            else R.drawable.badimage
        )
    }

    /** Resets score & flags, then starts a fresh game */
    fun resetGame() {
        _uiState.value = GameUiState()  // clear everything
        randomWord()                    // first question of the new session
    }
}
