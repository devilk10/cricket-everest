package cricket.everest.data

import cricket.everest.domain.commentary.CommentaryStrategy
import cricket.everest.domain.models.Runs
import cricket.everest.domain.models.Shot
import cricket.everest.domain.models.Wicket
import cricket.everest.domain.play.ShotStrategy

object ShotStrategies {
    val yorkerStrategy = ShotStrategy("Yorker").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("SquareCut"))
        addBadShot(Shot("LegLance"))

        addGoodShot(Shot("Long_On"))
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
        addGoodShot(Shot("Long_On"))
        addGoodShot(Shot("Scoop"))
        addGoodShot(Shot("Straight"))
    }

    val bouncerStrategy = ShotStrategy("Bouncer").apply {
        addGoodShot(Shot("Pull"))
        addGoodShot(Shot("Flick"))
        addGoodShot(Shot("UpperCut"))
        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("LegLance"))

        addBadShot(Shot("Long_On"))
        addBadShot(Shot("Sweep"))
        addBadShot(Shot("Scoop"))
        addBadShot(Shot("Straight"))
        addBadShot(Shot("CoverDrive"))
    }

    val offBreakStrategy = ShotStrategy("Off_Break").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("SquareCut"))
        addBadShot(Shot("LegLance"))

        addGoodShot(Shot("Long_On"))
        addGoodShot(Shot("Sweep"))
        addGoodShot(Shot("Scoop"))
        addGoodShot(Shot("Straight"))
        addGoodShot(Shot("CoverDrive"))
    }

    val legCutterStrategy = ShotStrategy("Leg_Cutter").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("CoverDrive"))
        addBadShot(Shot("Long_On"))
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
        addGoodShot(Shot("Long_On"))
        addGoodShot(Shot("Scoop"))
        addGoodShot(Shot("Straight"))
        addGoodShot(Shot("CoverDrive"))
    }

    val slowerBallStrategy = ShotStrategy("Slower_Ball").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("LegLance"))
        addBadShot(Shot("Straight"))

        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("Long_On"))
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
        addGoodShot(Shot("Long_On"))
        addGoodShot(Shot("Straight"))
        addGoodShot(Shot("CoverDrive"))
    }

    val offCutterBallStrategy = ShotStrategy("Off_Cutter").apply {
        addBadShot(Shot("Scoop"))
        addBadShot(Shot("Flick"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("LegLance"))
        addBadShot(Shot("Straight"))
        addBadShot(Shot("CoverDrive"))

        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("Long_On"))
        addGoodShot(Shot("Sweep"))
        addGoodShot(Shot("Pull"))
    }

    val doosraCutterBallStrategy = ShotStrategy("Doosra").apply {
        addBadShot(Shot("Pull"))
        addBadShot(Shot("UpperCut"))
        addBadShot(Shot("LegLance"))
        addBadShot(Shot("Straight"))
        addBadShot(Shot("CoverDrive"))
        addBadShot(Shot("Long_On"))

        addGoodShot(Shot("Flick"))
        addGoodShot(Shot("SquareCut"))
        addGoodShot(Shot("Sweep"))
        addGoodShot(Shot("Scoop"))
    }
}

object CommentaryStrategies {
    val wicketStrategy = CommentaryStrategy(Wicket).apply {
        addMessage(CommentaryMessages.edgeAndTaken)
        addMessage(CommentaryMessages.itsAWicket)
    }

    val zeroRunsStrategy = CommentaryStrategy(Runs(0)).apply {
        addMessage(CommentaryMessages.excellentLineAndLength)
    }

    val oneRunStrategy = CommentaryStrategy(Runs(1)).apply {
        addMessage(CommentaryMessages.excellentRunningBetweenTheWicket)
    }

    val twoRunsStrategy = CommentaryStrategy(Runs(2)).apply {
        addMessage(CommentaryMessages.excellentRunningBetweenTheWicket)
        addMessage(CommentaryMessages.excellentEffortOnTheBoundary)
        addMessage(CommentaryMessages.convertOnesIntoTwos)
    }

    val threeRunsStrategy = CommentaryStrategy(Runs(3)).apply {
        addMessage(CommentaryMessages.excellentRunningBetweenTheWicket)
        addMessage(CommentaryMessages.excellentEffortOnTheBoundary)
    }

    val fourRunsStrategy = CommentaryStrategy(Runs(4)).apply {
        addMessage(CommentaryMessages.overTheFielder)
    }

    val fiveRunsStrategy = CommentaryStrategy(Runs(5)).apply {
        addMessage(CommentaryMessages.overThrow)
    }

    val sixRunsStrategy = CommentaryStrategy(Runs(6)).apply {
        addMessage(CommentaryMessages.outOfTheGround)
        addMessage(CommentaryMessages.overTheFielder)
    }
}