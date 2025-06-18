package com.example.recyclerviewproject.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModelResponse(
    @SerialName("modelos") val models: List<ModelItemResponse>
) {
    @Serializable
    data class ModelItemResponse(
        @SerialName("codigo") val code: Int,
        @SerialName("nome") val name: String
    )
}
