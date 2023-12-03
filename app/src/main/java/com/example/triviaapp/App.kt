package com.example.triviaapp


import androidx.compose.runtime.Composable

@Composable
fun App(viewModel : QuestionViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    Question(viewModel)
}
