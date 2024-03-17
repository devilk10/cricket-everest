package cricket.everest.domain.predictor

import cricket.everest.domain.models.Runs
import cricket.everest.domain.models.Shot
import cricket.everest.domain.models.ShotTiming
import cricket.everest.domain.models.Wicket
import cricket.everest.domain.Constants.MAX_RUNS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ShotStrategyTest {

    private lateinit var shotStrategy: ShotStrategy

    @BeforeEach
    fun setUp() {
        shotStrategy = ShotStrategy("Yorker")
    }

    @Test
    fun `add good shot will return some runs`() {
        shotStrategy.addGoodShot(Shot("Flick"))
        val outcome = shotStrategy.getOutcome(Shot("Flick"), ShotTiming.Perfect)
        assertTrue(outcome is Runs)
        assertTrue((outcome as Runs).value < MAX_RUNS + 1)
    }

    @Test
    fun `bad shot will return wicket with bad timing`() {
        shotStrategy.addBadShot(Shot("Pull"))
        assertEquals(shotStrategy.getOutcome(Shot("Pull"), ShotTiming.Late), Wicket)
    }

    @Test
    fun `getOutcome throws an exception when shot is not present in it's directory`() {
        assertThrows<IllegalArgumentException> {
            assertEquals(shotStrategy.getOutcome(Shot("Cover Drive"), ShotTiming.Late), Wicket)
        }
    }
}