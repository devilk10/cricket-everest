package com.ketansa.cricket.domain.play

import com.ketansa.cricket.domain.play.Constants.MAX_RUNS
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
            goodShots.contains(shot) && isBadTiming(timing) -> Runs(Random.nextInt(4))
            badShots.contains(shot) && isGoodTiming(timing) -> Runs(Random.nextInt(4))
            badShots.contains(shot) && isBadTiming(timing) -> Wicket
            else -> throw IllegalArgumentException("Unknown shot: ${shot.name}")
        }
    }

    private fun isGoodTiming(timing: ShotTiming): Boolean {
        return timing == ShotTiming.Perfect || timing == ShotTiming.Good
    }

    private fun isBadTiming(timing: ShotTiming): Boolean {
        return timing == ShotTiming.Late || timing == ShotTiming.Early
    }

}