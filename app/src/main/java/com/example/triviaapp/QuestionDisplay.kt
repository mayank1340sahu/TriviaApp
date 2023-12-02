package com.example.triviaapp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun QuestionDisplay() {
    Surface(
        Modifier
            .fillMaxSize(),
        color = Color(0xFF13023C)
    ) {
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f)
        Column(Modifier.padding(4.dp)) {
            QuestionCounter()
            DrawDottedLine(pathEffect)
        }
    }
}

@Preview
@Composable
fun Pre() {
    QuestionDisplay()
}