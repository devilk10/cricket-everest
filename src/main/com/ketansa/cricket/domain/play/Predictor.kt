package com.ketansa.cricket.domain.play

import com.ketansa.cricket.domain.play.Constants.MAX_RUNS
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
