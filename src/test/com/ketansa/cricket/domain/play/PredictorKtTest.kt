package com.ketansa.cricket.domain.play

import com.ketansa.cricket.data.ShotStrategies
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PredictorKtTest {
    private lateinit var predictor: Predictor

    @BeforeEach
    fun setUp() {
        predictor = Predictor(shotStrategies = listOf(ShotStrategies.yorkerStrategy))
    }

    @Test
    fun `should return a wicket when tried to play a pull shot on yorker`() {
        assertEquals(predictor.predictOutcomeFor(Shot("Pull"), "Yorker", ShotTiming.Late), Wicket)
    }

    @Test
    fun `should return some runs when a good shot is played on yorker`() {
        val outcome =
            predictor.predictOutcomeFor(Shot("Straight Drive"), "Yorker", ShotTiming.Perfect)
        assertTrue(outcome is Runs)
        assertTrue((outcome as Runs).value < Constants.MAX_RUNS + 1)
    }
}