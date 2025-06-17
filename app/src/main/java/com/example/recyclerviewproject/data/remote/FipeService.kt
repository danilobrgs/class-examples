package com.example.recyclerviewproject.data.remote

import com.example.recyclerviewproject.data.model.BrandResponse
import retrofit2.Response
import retrofit2.http.GET

interface FipeService {
    @GET("carros/marcas")
    suspend fun getBrands(): Response<List<BrandResponse>>
}
