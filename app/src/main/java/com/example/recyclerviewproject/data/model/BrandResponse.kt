package com.example.recyclerviewproject.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BrandResponse(
    @SerialName("codigo") val code: String,
    @SerialName("nome") val name: String
)