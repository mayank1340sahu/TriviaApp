package com.example.triviaapp.model

data class questionItem(
    val category: String,
    val correctAnswer: String,
    val difficulty: String,
    val id: String,
    val incorrectAnswers: List<String>,
    val isNiche: Boolean,
    val question: QuestionX,
    val regions: List<Any>,
    val tags: List<String>,
    val type: String
)