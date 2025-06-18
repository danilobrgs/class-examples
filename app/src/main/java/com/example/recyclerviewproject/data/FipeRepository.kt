package com.example.recyclerviewproject.data

import com.example.recyclerviewproject.data.remote.FipeService
import com.example.recyclerviewproject.data.model.BrandResponse
import com.example.recyclerviewproject.data.model.ModelResponse

class FipeRepository(private val service: FipeService) {

    suspend fun getBrands(): List<BrandResponse>? {
        val response = service.getBrands()
        return if (response.isSuccessful) response.body() else null
    }

    suspend fun getModels(code: String): List<ModelResponse.ModelItemResponse>? {
        val response = service.getModels(code)
        return if (response.isSuccessful) response.body()?.models else null
    }
}