package com.example.triviaapp.model

data class WorldItem(
   val answer: String,
   val category: String,
   val choices: List<String>,
  val question: String
)