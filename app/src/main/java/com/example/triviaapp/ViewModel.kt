package com.example.triviaapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp.model.WorldItem
import com.example.triviaapp.model.questionItem
import com.example.triviaapp.repositor.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: Repository) :ViewModel() {
  val data : MutableState<DataOrException<ArrayList<questionItem>,Boolean,Exception>>
    = mutableStateOf(DataOrException(null,true,java.lang.Exception("")))

    init{
        getAllQuestions()
    }

    private fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllNotes()
            if(data.value.data.toString().isNotEmpty()) data.value.loading = false
        }
    }
    fun getSize(): Int {
        return data.value.data?.toMutableList()?.size!!
    }
}