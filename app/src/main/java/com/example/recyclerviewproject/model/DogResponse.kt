package com.example.recyclerviewproject.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DogResponse(
    @SerialName("message") val imageUrl: String,
    @SerialName("status") val status: String
)