package cricket.everest.domain.play

sealed class Outcome

data class Runs(val value: Int) : Outcome()
object Wicket : Outcome()
