package com.ketansa.cricket.data

import com.ketansa.cricket.domain.play.Shot
import com.ketansa.cricket.domain.play.ShotStrategy

object ShotStrategies {
    val yorkerStrategy = ShotStrategy("Yorker").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("SquareCut"))
        addBadShot(Shot("LegLance"))

        addGoodShot(Shot("Long On"))
        addGoodShot(Shot("Sweep"))
        addGoodShot(Shot("Scoop"))
        addGoodShot(Shot("Straight"))
        addGoodShot(Shot("CoverDrive"))
    }

    val outSwingerStrategy = ShotStrategy("Outswinger").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("CoverDrive"))
        addBadShot(Shot("LegLance"))
        addBadShot(Shot("Sweep"))

        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("Long On"))
        addGoodShot(Shot("Scoop"))
        addGoodShot(Shot("Straight"))
    }

    val bouncerStrategy = ShotStrategy("Bouncer").apply {
        addGoodShot(Shot("Pull"))
        addGoodShot(Shot("Flick"))
        addGoodShot(Shot("UpperCut"))
        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("LegLance"))

        addBadShot(Shot("Long On"))
        addBadShot(Shot("Sweep"))
        addBadShot(Shot("Scoop"))
        addBadShot(Shot("Straight"))
        addBadShot(Shot("CoverDrive"))
    }

    val offBreakStrategy = ShotStrategy("Off Break").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("SquareCut"))
        addBadShot(Shot("LegLance"))

        addGoodShot(Shot("Long On"))
        addGoodShot(Shot("Sweep"))
        addGoodShot(Shot("Scoop"))
        addGoodShot(Shot("Straight"))
        addGoodShot(Shot("CoverDrive"))
    }

    val legCutterStrategy = ShotStrategy("Leg Cutter").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("CoverDrive"))
        addBadShot(Shot("Long On"))
        addBadShot(Shot("Sweep"))

        addGoodShot(Shot("LegLance"))
        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("Scoop"))
        addGoodShot(Shot("Straight"))
    }

    val inSwingerBallStrategy = ShotStrategy("Inswinger").apply {
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("SquareCut"))
        addBadShot(Shot("LegLance"))
        addBadShot(Shot("Sweep"))

        addGoodShot(Shot("Pull"))
        addGoodShot(Shot("Flick"))
        addGoodShot(Shot("Long On"))
        addGoodShot(Shot("Scoop"))
        addGoodShot(Shot("Straight"))
        addGoodShot(Shot("CoverDrive"))
    }

    val slowerBallStrategy = ShotStrategy("Slower Ball").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("LegLance"))
        addBadShot(Shot("Straight"))

        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("Long On"))
        addGoodShot(Shot("Sweep"))
        addGoodShot(Shot("Scoop"))
        addGoodShot(Shot("CoverDrive"))
    }

    val paceBallStrategy = ShotStrategy("Pace").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("LegLance"))
        addBadShot(Shot("Sweep"))
        addBadShot(Shot("Scoop"))

        addGoodShot(Shot("UpperCut"))
        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("Long On"))
        addGoodShot(Shot("Straight"))
        addGoodShot(Shot("CoverDrive"))
    }

    val offCutterBallStrategy = ShotStrategy("Off Cutter").apply {
        addBadShot(Shot("Scoop"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("LegLance"))
        addBadShot(Shot("Straight"))
        addBadShot(Shot("CoverDrive"))

        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("Long On"))
        addGoodShot(Shot("Sweep"))
        addGoodShot(Shot("Pull"))
    }

    val doosraCutterBallStrategy = ShotStrategy("Doosra").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("LegLance"))
        addBadShot(Shot("Straight"))
        addBadShot(Shot("CoverDrive"))
        addBadShot(Shot("Long On"))

        addGoodShot(Shot("Flick"))
        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("Sweep"))
        addGoodShot(Shot("Scoop"))
    }
}