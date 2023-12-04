package com.example.triviaapp


import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp.model.QuestionX
import com.example.triviaapp.model.questionItem

@Composable
fun QuestionDisplay(
    question : questionItem,
    //questionIndex : MutableState<Int>,
    //viewModel: QuestionViewModel,
    //onNextClick : (Int) -> Unit
) {
    val choiceState = rememberSaveable {
        mutableStateOf(question.incorrectAnswers)
    }
    val answerState = rememberSaveable {
        mutableStateOf<Int?>(null)
    }
    val correctAnswerState = rememberSaveable {
        mutableStateOf<Boolean?>(null)
    }
    val updateAnswerState:(Int) ->Unit =
        {
            answerState.value = it
            correctAnswerState.value = choiceState.value[it] == question.correctAnswer
        }

    Surface(
        Modifier
            .fillMaxSize(),
        color = Color(0xFF2A038A)
    ) {
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f)
        Column(Modifier.padding(4.dp)) {
            QuestionCounter()
            DrawDottedLine(pathEffect)
            Column(
                Modifier
                    .fillMaxHeight(0.3f)
                    .fillMaxWidth()) {
                Text(text = question.question.text,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFDFDEE2),
                    lineHeight = 22.sp
                )
                choiceState.value.forEachIndexed { index, s ->
                    Row(
                        modifier = Modifier
                            .width(300.dp)
                            .height(34.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .border(
                                4.dp, Brush.linearGradient(listOf(Color(0xFF5B29F1), Color.Blue)),
                                RectangleShape
                            )
                    ){
                        RadioButton(selected = answerState.value == index,
                            onClick = { updateAnswerState(index) })
                        Text(text = s)
                        Log.d("hgjghgj", "QuestionDisplay: QuestionDisplay")
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun gh() {
    val g = questionItem("fj","dk","er","rt", listOf("ty","dk","vn"),
        false, QuestionX("dgdss"), listOf("tr"), listOf("er","er"),"erter"
    )
    QuestionDisplay(question = g)

}
