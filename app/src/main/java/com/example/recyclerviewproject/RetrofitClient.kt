package com.example.recyclerviewproject

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

val json = Json { ignoreUnknownKeys = true }

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val service: DogService = retrofit.create(DogService::class.java)
}