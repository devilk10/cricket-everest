package cricket.everest.domain.predictor

import cricket.everest.domain.models.Runs
import cricket.everest.domain.models.Wicket
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OutcomeTest {
    @Test
    fun `should return 1 run when outcome is 1 run`() {
        assertEquals(Runs(1).toString(), "1 run")
    }

    @Test
    fun `should return 2 runs when outcome is 2 runs`() {
        assertEquals(Runs(2).toString(), "2 runs")
    }

    @Test
    fun `should return wicket when outcome is a wicket`() {
        assertEquals(Wicket.toString(), "Wicket")
    }
}