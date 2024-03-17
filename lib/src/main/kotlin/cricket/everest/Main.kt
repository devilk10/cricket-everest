package cricket.everest

import cricket.everest.data.Cards.battingCards
import cricket.everest.data.Cards.bowlingCards
import cricket.everest.data.Cards.shotTimings
import cricket.everest.data.CommentaryStrategies
import cricket.everest.data.ShotStrategies
import cricket.everest.domain.commentary.Commentator
import cricket.everest.domain.inning.Inning
import cricket.everest.domain.models.InningStatus
import cricket.everest.domain.models.Outcome
import cricket.everest.domain.models.Shot
import cricket.everest.domain.models.ShotTiming
import cricket.everest.domain.predictor.Predictor
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

    println("Select one of the options")
    println("1. Ball outcome prediction with commentary")
    println("2. Super over simulation with commentary")
    print("Enter 1 or 2: ")
    Scanner(System.`in`)

    if (readlnOrNull() == "1") {
        println("Input action in following format _BOWLING_CARD _BATTING_CARD _SHOT_TIMING")
        val outcome = predictionInputHandler(predictor)
        outcome?.let {
            val commentaryOutput = commentator.getCommentaryFor(it)
            println("Predicted Shot Outcome: $it")
            println(commentaryOutput)
        }
    } else {
        print("Enter Target for the super over - ")
        val target = readlnOrNull()
        target?.toInt()?.let {
            val inning = Inning(it)
            println("Your inning has started, the target is $it")

            println("Input action in following format _BOWLING_CARD _BATTING_CARD _SHOT_TIMING")
            while (inning.status == InningStatus.inProgress) {
                predictionInputHandler(predictor)?.let { outcome ->
                    inning.play(outcome)
                    println("${commentator.getCommentaryFor(outcome)} : $outcome")
                    println("${inning.status}, ${inning.score}")
                }
            }
        }
    }
}

private fun predictionInputHandler(
    predictor: Predictor,
): Outcome? {
    val input = readlnOrNull()?.split(" ") ?: return null
    if (validate(input)) return null

    val bowlingCard = input[0]
    val battingCard = input[1]
    val shotTiming = input[2]
    return predictor.predictOutcomeFor(
        Shot(battingCard), bowlingCard, ShotTiming.valueOf(shotTiming)
    )
}

private fun validate(input: List<String>): Boolean {
    if (input.size != 3) {
        println("Invalid input format. Please enter all three values separated by spaces.")
        return true
    }
    if (input[0] !in bowlingCards || input[1] !in battingCards || input[2] !in shotTimings) {
        println("Invalid input. Please enter valid bowling card, shot card, and shot timing.")
        println("Valid bowling cards are $bowlingCards")
        println("Valid batting cards are $battingCards")
        println("Valid shot timing cards are $shotTimings")
        return true
    }
    return false
}
