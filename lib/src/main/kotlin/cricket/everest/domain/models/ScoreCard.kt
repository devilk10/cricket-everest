package cricket.everest.domain.models

data class ScoreCard(var runs: Int, var wickets: Int, var balls: Int) {
    override fun toString(): String {
        return "Score - $runs/$wickets, $balls Balls"
    }
}