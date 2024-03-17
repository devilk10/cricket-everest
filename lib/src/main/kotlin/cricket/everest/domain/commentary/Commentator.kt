package cricket.everest.domain.commentary

import cricket.everest.domain.models.Outcome
import cricket.everest.domain.models.Shot
import cricket.everest.domain.models.ShotTiming

class Commentator {
    fun speak(outcome: Outcome, shot: Shot, bowlingCard: String, valueOf: ShotTiming) {
        println("$bowlingCard ball played $shot and $outcome")
    }

}
