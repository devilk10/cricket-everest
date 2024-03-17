package cricket.everest.domain.predictor

import cricket.everest.domain.models.Outcome
import cricket.everest.domain.models.Runs
import cricket.everest.domain.models.Shot
import cricket.everest.domain.models.ShotTiming
import cricket.everest.domain.Constants.MAX_RUNS
import kotlin.random.Random

class Predictor(private val shotStrategies: List<ShotStrategy>) {
    fun predictOutcomeFor(shotType: Shot, ballType: String, shotTiming: ShotTiming): Outcome {
        try {
            return shotStrategies.find { it.ballType == ballType }?.getOutcome(shotType, shotTiming)
                ?: Runs(Random.nextInt(MAX_RUNS + 1))
        } catch (e: Exception) {
            throw IllegalArgumentException("Unsupported ball type: $ballType")
        }
    }
}
