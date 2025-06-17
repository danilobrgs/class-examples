package com.example.recyclerviewproject.data

import com.example.recyclerviewproject.data.remote.FipeService
import com.example.recyclerviewproject.data.model.BrandResponse

class FipeRepository(private val service: FipeService) {
    suspend fun getBrands(): List<BrandResponse>? {
        val response = service.getBrands()
        return if (response.isSuccessful) response.body() else null
    }
}