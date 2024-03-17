package cricket.everest.domain.inning

import cricket.everest.domain.models.InningStatus
import cricket.everest.domain.models.Outcome
import cricket.everest.domain.models.Runs

class Inning(
    private val target: Int, private val totalBalls: Int = 6, private val totalWickets: Int = 2
) {
    val score: ScoreCard = ScoreCard(runs = 0, wickets = 0, balls = 0)
    var status = InningStatus.inProgress
    fun play(ballOutcome: Outcome) {
        if (status != InningStatus.inProgress) throw IllegalStateException("Inning finished")
        score.balls++
        if (ballOutcome is Runs) score.runs += ballOutcome.value else score.wickets++

        status = if (score.runs >= target) InningStatus.won
        else if (score.wickets == totalWickets) InningStatus.lost
        else if (score.balls == totalBalls) InningStatus.lost
        else InningStatus.inProgress
    }

}

data class ScoreCard(var runs: Int, var wickets: Int, var balls: Int) {
    override fun toString(): String {
        return "Score - $runs/$wickets, $balls Balls"
    }
}
