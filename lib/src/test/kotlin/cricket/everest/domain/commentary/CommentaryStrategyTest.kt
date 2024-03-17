package cricket.everest.domain.commentary

import cricket.everest.domain.models.Wicket
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CommentaryStrategyTest {

    @Test
    fun `should return added message`() {
        val commentaryStrategy = CommentaryStrategy(Wicket)
        commentaryStrategy.addMessage("some fancy commentary")
        assertEquals("some fancy commentary", commentaryStrategy.getMessage())
    }

    @Test
    fun `should return empty message when there are no messages present`() {
        val commentaryStrategy = CommentaryStrategy(Wicket)
        assertEquals("", commentaryStrategy.getMessage())
    }
}