package com.example.triviaapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ScoreScreen(score : Int,restart:()-> Unit) {
    Surface(color = Color(0xFF2A038A),
        modifier = Modifier.fillMaxSize()
        ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Your Score",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(
                        0xFFFFFBFB
                    )
                )

                Text(
                    text = "$score",
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(
                        0xFFFFFBFB
                    )
                )
                Button(onClick = { restart() }) {
                    Text(text = "Play Again")
                }
            }
        }
    }
}