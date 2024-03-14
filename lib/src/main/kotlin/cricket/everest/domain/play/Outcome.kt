package cricket.everest.domain.play

sealed class Outcome

data class Runs(val value: Int) : Outcome() {
    override fun toString(): String {
        return "$value ${if (value == 1) "run" else "runs"}"
    }
}

object Wicket : Outcome() {
    override fun toString(): String {
        return "Wicket"
    }
}
