package cricket.everest.domain.inning

import cricket.everest.domain.models.InningStatus
import cricket.everest.domain.models.Outcome
import cricket.everest.domain.models.Runs

class Inning(
    private val target: Int, private val totalBalls: Int = 6, private val totalWickets: Int = 2
) {
    var status = InningStatus.inProgress
    private var runs = 0
    private var wickets = 0
    private var balls = 0
    fun play(ballOutcome: Outcome) {
        if (status != InningStatus.inProgress) throw IllegalStateException("Inning finished")
        balls++
        if (ballOutcome is Runs) runs += ballOutcome.value else wickets++

        status = if (runs > target) InningStatus.won
        else if (wickets == totalWickets) InningStatus.lost
        else if (balls == totalBalls) InningStatus.lost
        else InningStatus.inProgress
    }

}