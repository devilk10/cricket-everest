package cricket.everest

import cricket.everest.data.Cards.battingCards
import cricket.everest.data.Cards.bowlingCards
import cricket.everest.data.Cards.shotTimings
import java.util.Scanner

fun main() {
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
        return
    }

    println("Predicted Shot Outcome: SOME RANDOM OUTPUT")
}
