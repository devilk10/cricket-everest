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
        addGoodShot(Shot("Cover Drive"))
        addBadShot(Shot("Flick"))
    }
}