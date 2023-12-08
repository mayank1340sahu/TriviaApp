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
){
    fun choiceMerge(): List<String> {
        val g = incorrectAnswers.toMutableList()
        g.add(correctAnswer)
        return g
    }
    fun randomization(): List<Int> {
        val g = mutableListOf<Int>()
        while (g.size < choiceMerge().size) {
            val randomIndex = (0 until choiceMerge().size).random()
            if (!g.contains(randomIndex)) {
                g.add(randomIndex)
            }
        }
        return g
    }

}