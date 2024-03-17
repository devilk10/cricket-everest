package cricket.everest.domain.commentary

import cricket.everest.domain.models.Outcome

class Commentator(private val commentaryStrategies: List<CommentaryStrategy>) {
    fun getCommentaryFor(outcome: Outcome): String {
        return commentaryStrategies.find { it.outcome == outcome }?.getMessage()
            ?: "Commentary error"
    }

}
