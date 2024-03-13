package com.ketansa.cricket.domain.play


sealed class Outcomes

data class Runs(val runs: Int) : Outcomes()
data object Wicket : Outcomes()
