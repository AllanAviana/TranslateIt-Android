package com.example.translateit_android

import com.example.translateit_android.data.GameRepository
import com.example.translateit_android.presentation.viewmodel.GameViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import org.junit.Test

class GameViewModelTest {
    @Test
    fun result_correctAnswer_incrementsScore() {
        val vm = GameViewModel(GameRepository())

        val initialScore = vm.uiState.value.score
        val correct = vm.uiState.value.answer

        vm.result(correct)

        assertEquals(initialScore + 10, vm.uiState.value.score)
        assertFalse(vm.uiState.value.isGameOver)
    }

}