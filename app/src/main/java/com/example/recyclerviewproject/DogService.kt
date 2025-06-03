package com.example.recyclerviewproject

import com.example.recyclerviewproject.model.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogService {
    @GET("breeds/image/random")
    suspend fun getRandomDog(): Response<DogResponse>
}