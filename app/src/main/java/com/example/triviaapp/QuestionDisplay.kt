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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp.model.questionItem

@Composable
fun QuestionDisplay(
    question : questionItem,
    questionIndex : MutableState<Int>,
    onNextClick : (Int) -> Unit

) {
    val choiceState = remember {
        mutableStateOf(question.choiceMerge())
    }

    Log.d("QuestionDisplay", "New Question: ${question.question.text}")
    Log.d("QuestionDisplay", "New Choices: ${question.choiceMerge()}")
    Log.d("QuestionDisplay", "Current choiceState: ${choiceState.value}")

    val r = remember {
        mutableStateOf(question.randomization())
    }

    Log.d("Random", "QuestionDisplay:${r.value}")
    Log.d("Randomization", "QuestionDisplay: ${question.randomization()}")


    val answerState = remember {
        mutableStateOf<Int?>(null)
    }

    val correctAnswerState = remember {
        mutableStateOf<Boolean?>(null)
    }

    val click = remember {
        mutableStateOf(false)
    }

    val updateAnswerState:(Int) ->Unit =
        {
            answerState.value = it
            correctAnswerState.value = choiceState.value[it] == question.correctAnswer
        }

    LaunchedEffect(question){
        choiceState.value = question.choiceMerge()
       answerState.value = null
        correctAnswerState.value = null
        click.value = false
        r.value = question.randomization()
    }
    Surface(
        Modifier
            .fillMaxSize(),
        color = Color(0xFF2A038A)
    ) {
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f)
        Column(Modifier.padding(4.dp)) {
            QuestionCounter(count = questionIndex.value+1,10)
            DrawDottedLine(pathEffect)
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()) {
                Text(text = question.question.text,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFDFDEE2),
                    lineHeight = 22.sp,
                    modifier = Modifier.fillMaxHeight(.3f)
                )
                r.value.forEach { s ->
                    Row(
                        modifier = Modifier
                            .width(300.dp)
                            .height(70.dp)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .border(
                                4.dp, Brush.linearGradient(listOf(Color(0xFF5B29F1), Color.Blue)),
                                RectangleShape
                            )
                    ){
                        RadioButton(selected = answerState.value == s,
                            onClick = {
                                if(!click.value)
                                {
                                    updateAnswerState(s)
                                click.value = !click.value
                                }
                            },
                            colors = RadioButtonDefaults.colors(
                                if (correctAnswerState.value == true){
                                    Color(0xFF5EF500)
                                }
                            else{
                                Color(0xFFF71616)
                                }
                            )
                        )
                        Text(text = choiceState.value[s],
                            color = if ((choiceState.value[s] == question.correctAnswer) && (correctAnswerState.value == true)){
                                Color(0xFF5EF500)
                            }
                            else if((correctAnswerState.value == false) && (choiceState.value[s] != question.correctAnswer)){
                                Color(0xFFF71616)
                            }
                            else {
                                Color(0xFFFFF0F0)
                            }
                        )
                    }

                }
                if(correctAnswerState.value != null){
                    Text(text = question.correctAnswer,
                        color = Color(0xFFFFF0F0),
                        modifier = Modifier.padding(6.dp))
            }
                Button(onClick = {
                        onNextClick(questionIndex.value)
                },
                shape = RoundedCornerShape(34.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF04CBEE),
                        contentColor =  Color(0xFFFFF0F0))
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

