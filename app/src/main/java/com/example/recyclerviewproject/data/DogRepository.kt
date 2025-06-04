package com.example.recyclerviewproject.data

import com.example.recyclerviewproject.data.remote.DogService
import com.example.recyclerviewproject.data.model.DogResponse

class DogRepository(private val service: DogService) {
    suspend fun getRandomDog(): DogResponse? {
        val response = service.getRandomDog()
        return if (response.isSuccessful) response.body() else null
    }
}