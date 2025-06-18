package com.example.recyclerviewproject.adapterAux

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerviewproject.data.model.ModelResponse

class ModelsDiffCallback : DiffUtil.ItemCallback<ModelResponse.ModelItemResponse>() {
    override fun areItemsTheSame(oldItem: ModelResponse.ModelItemResponse, newItem: ModelResponse.ModelItemResponse): Boolean =
        oldItem.code == newItem.code

    override fun areContentsTheSame(oldItem: ModelResponse.ModelItemResponse, newItem: ModelResponse.ModelItemResponse): Boolean =
        oldItem == newItem
}