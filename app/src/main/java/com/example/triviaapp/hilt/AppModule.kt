package com.example.triviaapp.hilt

import com.example.triviaapp.Constant
import com.example.triviaapp.network.QuestionApi
import com.example.triviaapp.repositor.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository(api: QuestionApi) = Repository(api)

    @Singleton
    @Provides
    fun provideRetrofit():QuestionApi{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }
}
