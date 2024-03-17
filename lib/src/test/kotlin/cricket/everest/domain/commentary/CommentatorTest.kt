package cricket.everest.domain.commentary

import cricket.everest.data.CommentaryMessages
import cricket.everest.domain.models.Runs
import cricket.everest.domain.models.Wicket
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CommentatorTest {

    @Test
    fun `should return a commentary message for wicket outcome`() {
        val commentator = Commentator(listOf(CommentaryStrategy(Wicket).apply {
            addMessage(CommentaryMessages.itsAWicket)
        }))
        val commentaryFor = commentator.getCommentaryFor(Wicket)
        assertEquals(commentaryFor, CommentaryMessages.itsAWicket)
    }

    @Test
    fun `should return a commentary message for 6 runs outcome`() {
        val commentator = Commentator(listOf(CommentaryStrategy(Runs(6)).apply {
            addMessage(CommentaryMessages.outOfTheGround)
        }))
        val commentaryFor = commentator.getCommentaryFor(Runs(6))
        assertEquals(commentaryFor, CommentaryMessages.outOfTheGround)
    }

    @Test
    fun `should get a commentary error for strategy is not define for an outcome`() {
        val commentator = Commentator(listOf(CommentaryStrategy(Runs(2)).apply {
            addMessage(CommentaryMessages.itsAWicket)
        }))
        val commentaryFor = commentator.getCommentaryFor(Wicket)
        assertEquals(commentaryFor, "Commentary error")
    }
}