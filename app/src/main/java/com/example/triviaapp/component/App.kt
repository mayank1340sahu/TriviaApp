package com.example.triviaapp.component

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviaapp.QuestionViewModel

@Composable
fun App(viewModel: QuestionViewModel = hiltViewModel()) {
    Question(viewModel)
}
