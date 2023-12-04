package com.example.triviaapp.repositor

import android.util.Log
import com.example.triviaapp.DataOrException
import com.example.triviaapp.model.WorldItem
import com.example.triviaapp.model.questionItem
import com.example.triviaapp.network.QuestionApi
import javax.inject.Inject

class Repository @Inject constructor(private val api: QuestionApi) {
    
    private val dataOrException =DataOrException<ArrayList<questionItem>,Boolean,Exception>()
    
    suspend fun getAllNotes():DataOrException<ArrayList<questionItem>,Boolean,Exception>{
        try{
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestion()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        }
        catch (e:java.lang.Exception){
            dataOrException.e = e
            Log.d("From Repository", "getAllNotes: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}