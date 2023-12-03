package com.example.triviaapp.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun QuestionDisplay() {
    Surface(
        Modifier
            .fillMaxSize(),
        color = Color(0xFF13023C)
            ) {
Column {
    QuestionCounter()
}
    }
}

@Preview
@Composable
fun Pre() {
    QuestionDisplay()
}