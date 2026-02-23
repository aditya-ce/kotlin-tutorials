package com.example.unscramble.ui

data class GameUiState(
    val currentScrambleWord: String = "",
    val isGuessedWordWrong: Boolean = false,
    val currentWordCount: Int = 1,
    val score: Int = 0
)