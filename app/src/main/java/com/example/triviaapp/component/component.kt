package com.example.triviaapp.component

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviaapp.QuestionViewModel

@Composable
fun Question(viewModel: QuestionViewModel) {
    val dataOrException = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true)
    {
        CircularProgressIndicator()
        Log.d("Loading", "Question: loading") }
    else Log.d("loading", "Question: loading Stopped")
    dataOrException?.forEach{
        Log.d("Result", "Question:${it.question} ")
    }
}