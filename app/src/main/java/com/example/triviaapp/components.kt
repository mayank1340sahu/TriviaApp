package com.example.triviaapp

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

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

@Composable
fun QuestionCounter(count:Int = 3, outOf: Int =100){
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textIndent = TextIndent.None)) {
            withStyle(SpanStyle(color = Color(0xFF9B9B9B),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )){
                append("Question $count/")
                withStyle(SpanStyle(fontSize = 27.sp)){
                    append("$outOf")
                }
            }
        }
    })
}