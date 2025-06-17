package com.example.recyclerviewproject.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

val json = Json { ignoreUnknownKeys = true }

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://parallelum.com.br/fipe/api/v1/")
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val service: FipeService = retrofit.create(FipeService::class.java)
}