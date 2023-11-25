package com.example.triviaapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviaapp.ui.theme.TriviaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  App()
                }
            }
        }
    }
}

@Composable
fun App(viewModel:QuestionViewModel = hiltViewModel()) {
   Question(viewModel)
}

@Composable
fun Question(viewModel: QuestionViewModel) {
    val dataOrException = viewModel.data.value.data?.toMutableList()

    Log.d("SIZE", "Question:${dataOrException?.size} ")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TriviaAppTheme {

    }
}