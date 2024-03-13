package com.ketansa.cricket.domain.play

import org.junit.jupiter.api.Assertions.assertEquals

class PredictorKtTest {
    @org.junit.jupiter.api.Test
    fun `should return a wicket when tried to play a pull shot on yorker`() {
        assertEquals(predictOutcomeFor("pull", "yorker", "good"), Wicket)
    }
}