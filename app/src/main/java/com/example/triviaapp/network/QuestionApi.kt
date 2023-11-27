package com.example.triviaapp.network

import com.example.triviaapp.model.World
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
   suspend fun getAllQuestion():World
}