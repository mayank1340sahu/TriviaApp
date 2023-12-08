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
        var t = listOf(3)
       val f = choiceMerge().indexOf(choiceMerge().first())
        val r = choiceMerge().indexOf(choiceMerge().last())
        val g = mutableListOf<Int>()
            while(t.indexOf(t.last()) != r){
                  g.add(
                    (choiceMerge().indexOf(choiceMerge().first())..choiceMerge().indexOf(
                        choiceMerge().last()
                    )).random()
                )
                t = g.distinct()
            }
    return t
    }
}