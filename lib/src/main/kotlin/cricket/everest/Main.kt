package cricket.everest

import cricket.everest.data.Cards.battingCards
import cricket.everest.data.Cards.bowlingCards
import cricket.everest.data.Cards.shotTimings
import cricket.everest.data.CommentaryStrategies
import cricket.everest.data.ShotStrategies
import cricket.everest.domain.commentary.Commentator
import cricket.everest.domain.models.Outcome
import cricket.everest.domain.models.Shot
import cricket.everest.domain.models.ShotTiming
import cricket.everest.domain.play.Predictor
import java.util.Scanner

fun main() {
    val predictor = Predictor(
        shotStrategies = listOf(
            ShotStrategies.yorkerStrategy,
            ShotStrategies.offCutterBallStrategy,
            ShotStrategies.slowerBallStrategy,
            ShotStrategies.doosraCutterBallStrategy,
            ShotStrategies.paceBallStrategy,
            ShotStrategies.outSwingerStrategy,
            ShotStrategies.inSwingerBallStrategy,
            ShotStrategies.offBreakStrategy,
            ShotStrategies.legCutterStrategy,
            ShotStrategies.bouncerStrategy,
        )
    )
    val commentator = Commentator(
        commentaryStrategies = listOf(
            CommentaryStrategies.wicketStrategy,
            CommentaryStrategies.zeroRunsStrategy,
            CommentaryStrategies.oneRunStrategy,
            CommentaryStrategies.twoRunsStrategy,
            CommentaryStrategies.threeRunsStrategy,
            CommentaryStrategies.fourRunsStrategy,
            CommentaryStrategies.fiveRunsStrategy,
            CommentaryStrategies.sixRunsStrategy,
        )
    )

    println("Input action in following format _BOWLING_CARD _BATTING_CARD _SHOT_TIMING")
    Scanner(System.`in`)
    val input = readlnOrNull()?.split(" ") ?: return
    if (input.size != 3) {
        println("Invalid input format. Please enter all three values separated by spaces.")
        return
    }

    val bowlingCard = input[0]
    val battingCard = input[1]
    val shotTiming = input[2]

    if (bowlingCard !in bowlingCards || battingCard !in battingCards || shotTiming !in shotTimings) {
        println("Invalid input. Please enter valid bowling card, shot card, and shot timing.")
        println("Valid bowling cards are $bowlingCards")
        println("Valid batting cards are $battingCards")
        println("Valid shot timing cards are $shotTimings")
        return
    }

    val outcome: Outcome =
        predictor.predictOutcomeFor(Shot(battingCard), bowlingCard, ShotTiming.valueOf(shotTiming))

    val commentaryOutput = commentator.getCommentaryFor(outcome)
    println("Predicted Shot Outcome: $outcome")
    println(commentaryOutput)
}
