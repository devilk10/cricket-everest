package com.ketansa.cricket.domain.play

sealed class Outcome

data class Runs(val value: Int) : Outcome()
data object Wicket : Outcome()
