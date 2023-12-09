package com.example.triviaapp

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Question(viewModel: QuestionViewModel) {
    val dataOrException = viewModel.data.value.data?.toMutableList()

    val questionIndex = rememberSaveable {
        mutableStateOf(0)
    }

    if (viewModel.data.value.loading == true)
    {
        CircularProgressIndicator()
        Log.d("Loading", "Question: loading") }
    else {
        Log.d("loading", "Question: loading Stopped")

            if (dataOrException != null) {
            if (questionIndex.value <10)
                { val currentQuestion = dataOrException[questionIndex.value]
                Log.d("Question", "Current Question: ${currentQuestion.question.text}")
            QuestionDisplay(question =currentQuestion,questionIndex,viewModel){
                questionIndex.value = it+1
            }
            }
                else{
                    questionIndex.value = 0
            }
            }
    }

    dataOrException?.forEach{
        Log.d("Result", "Question:  ${it.correctAnswer}")
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

@Composable
fun ProgressBar(score:Int ) {
        val gradient = Brush.linearGradient(listOf(Color(0xFFE93873),Color(0xFFB90BD6)))

        val progressFactor = remember(score){ mutableStateOf(score.toFloat() / 10) }

        Row(modifier = Modifier
            .height(45.dp)
            .fillMaxWidth()
            .border(
                width = 4.dp,
                brush = Brush.linearGradient(listOf(Color(0xFF5B29F1), Color(0xFF03A9F4))),
                shape = RoundedCornerShape(34.dp)
            )
            .clip(RoundedCornerShape(50))
            .background(Color.Transparent)) {
            Button(onClick = {},
                contentPadding = PaddingValues(1.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent),
                elevation = null,
                enabled = false,
                modifier = Modifier
                    .background(brush = gradient)
                    .fillMaxWidth(progressFactor.value)
            ) {
                Text(text = "$score", fontSize = 34.sp)
            }
        }
}