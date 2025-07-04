package com.example.translateit_android

import com.example.translateit_android.data.GameRepository
import org.junit.Assert.*
import org.junit.Test

class GameRepositoryTest {

    private val repo = GameRepository()

    @Test
    fun generateQuestion_returnsValidData() {
        val (en, ptCorrect, options) = repo.generateQuestion()

        assertTrue(options.contains(ptCorrect))

        assertEquals(4, options.size)

        assertEquals(options.size, options.toSet().size)

        assertTrue(en.isNotBlank())
    }
}
