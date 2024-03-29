package cricket.everest.domain.predictor

import cricket.everest.domain.Constants.FOUR_RUNS
import cricket.everest.domain.Constants.MAX_RUNS
import cricket.everest.domain.models.Outcome
import cricket.everest.domain.models.Runs
import cricket.everest.domain.models.Shot
import cricket.everest.domain.models.ShotTiming
import cricket.everest.domain.models.Wicket
import kotlin.random.Random

class ShotStrategy(val ballType: String) {
    private val goodShots = mutableListOf<Shot>()
    private val badShots = mutableListOf<Shot>()

    fun addGoodShot(shot: Shot) {
        goodShots.add(shot)
    }

    fun addBadShot(shot: Shot) {
        badShots.add(shot)
    }

    fun getOutcome(shot: Shot, timing: ShotTiming): Outcome {
        return when {
            goodShots.contains(shot) && isGoodTiming(timing) -> Runs(Random.nextInt(MAX_RUNS + 1))
            goodShots.contains(shot) && isBadTiming(timing) -> Runs(Random.nextInt(until = FOUR_RUNS))
            badShots.contains(shot) && isGoodTiming(timing) -> Runs(Random.nextInt(until = FOUR_RUNS))
            badShots.contains(shot) && isBadTiming(timing) -> Wicket
            else -> throw IllegalArgumentException("Strategy not defined for: ${shot.name}")
        }
    }

    private fun isGoodTiming(timing: ShotTiming): Boolean {
        return timing == ShotTiming.Perfect || timing == ShotTiming.Good
    }

    private fun isBadTiming(timing: ShotTiming): Boolean {
        return timing == ShotTiming.Late || timing == ShotTiming.Early
    }

}