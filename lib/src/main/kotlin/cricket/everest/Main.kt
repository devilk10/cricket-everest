package cricket.everest

import com.ketansa.cricket.data.ShotStrategies
import cricket.everest.data.Cards.battingCards
import cricket.everest.data.Cards.bowlingCards
import cricket.everest.data.Cards.shotTimings
import cricket.everest.domain.play.Outcome
import cricket.everest.domain.play.Predictor
import cricket.everest.domain.play.Shot
import cricket.everest.domain.play.ShotTiming
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
    println("Predicted Shot Outcome: $outcome")
}
