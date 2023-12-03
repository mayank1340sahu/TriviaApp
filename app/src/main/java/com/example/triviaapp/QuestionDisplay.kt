package com.example.triviaapp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp.model.WorldItem

@Composable
fun QuestionDisplay(
    question : WorldItem,
    questionIndex : MutableState<Int>,
    viewModel: QuestionViewModel,
    onNextClick : (Int) -> Unit
) {
    Surface(
        Modifier
            .fillMaxSize(),
        color = Color(0xFF2A038A)
    ) {
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f)
        Column(Modifier.padding(4.dp)) {
            QuestionCounter()
            DrawDottedLine(pathEffect)
            Column(Modifier.fillMaxHeight(0.3f).fillMaxWidth()) {
                Text(text = "What's the meaning of this",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFDFDEE2),
                    lineHeight = 22.sp
                )
                Row(){
                }
            }
        }

    }
}

