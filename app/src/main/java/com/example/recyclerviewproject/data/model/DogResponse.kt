package com.example.recyclerviewproject.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DogResponse(
    @SerialName("message") val imageUrl: String,
    @SerialName("status") val status: String
)