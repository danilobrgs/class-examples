package com.example.recyclerviewproject.data.remote

import com.example.recyclerviewproject.data.model.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogService {
    @GET("breeds/image/random")
    suspend fun getRandomDog(): Response<DogResponse>
}