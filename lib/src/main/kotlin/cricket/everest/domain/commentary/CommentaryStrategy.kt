package cricket.everest.domain.commentary

import cricket.everest.domain.models.Outcome
import kotlin.random.Random

class CommentaryStrategy(val outcome: Outcome) {
    private val messages: MutableList<String> = mutableListOf()

    fun getMessage(): String {
        return if (messages.size > 0) messages[Random.nextInt(messages.size)] else ""
    }

    fun addMessage(commentaryMessage: String) {
        messages.add(commentaryMessage)
    }
}