package com.example.triviaapp

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Question(viewModel: QuestionViewModel) {
    val dataOrException = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true)
    {
        CircularProgressIndicator()
        Log.d("Loading", "Question: loading") }
    else {
        Log.d("loading", "Question: loading Stopped")
    }

    if (dataOrException != null) {
        QuestionDisplay(question = dataOrException.first())
    }
    else
    {
        Log.d("TAG", "Question: ties lsd")
    }

    dataOrException?.forEach{
        Log.d("Result", "Question:${it.question} ")
    }
}

@Composable
fun DrawDottedLine(pathEffect: PathEffect){
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)){
        drawLine(pathEffect = pathEffect,start = Offset.Zero, end = Offset(size.width,0f), color = Color(0xFFF3F3F3))
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
    },
        Modifier.padding(4.dp))
}