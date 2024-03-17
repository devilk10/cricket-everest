package cricket.everest.domain.inning

import cricket.everest.domain.models.InningStatus
import cricket.everest.domain.models.Runs
import cricket.everest.domain.models.Wicket
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InningTest {

    @Test
    fun `should get status as in progress when target is not met on first ball`() {
        val inning = Inning(10)
        inning.play(Runs(3))
        assertEquals(inning.status, InningStatus.inProgress)
    }

    @Test
    fun `should get status as in won when target is reached`() {
        val inning = Inning(10)
        inning.play(Runs(3))
        inning.play(Runs(6))
        inning.play(Runs(2))
        assertEquals(inning.status, InningStatus.won)
    }

    @Test
    fun `should get status as lost when 6 balls are bowled and target is not reached`() {
        val inning = Inning(30)
        inning.play(Runs(3))
        inning.play(Runs(6))
        inning.play(Runs(2))
        inning.play(Runs(2))
        inning.play(Runs(2))
        inning.play(Runs(2))
        assertEquals(inning.status, InningStatus.lost)
    }

    @Test
    fun `should get status as lost when total wickets are fallen and target is not reached`() {
        val inning = Inning(30)
        inning.play(Runs(3))
        inning.play(Runs(6))
        inning.play(Wicket)
        inning.play(Wicket)
        assertEquals(inning.status, InningStatus.lost)
    }

    @Test
    fun `should throw an exception if tried to play when status is not in progress`() {
        val inning = Inning(30)
        inning.play(Runs(3))
        inning.play(Runs(6))
        inning.play(Wicket)
        inning.play(Wicket)
        assertThrows<IllegalStateException> {
            inning.play(Runs(2))
        }
    }

}