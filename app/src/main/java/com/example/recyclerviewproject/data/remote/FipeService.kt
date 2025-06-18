package com.example.recyclerviewproject.data.remote

import com.example.recyclerviewproject.data.model.BrandResponse
import com.example.recyclerviewproject.data.model.ModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FipeService {
    @GET("carros/marcas")
    suspend fun getBrands(): Response<List<BrandResponse>>

    @GET("carros/marcas/{codigo}/modelos")
    suspend fun getModels(@Path("codigo") brandCode: String): Response<ModelResponse>
}
