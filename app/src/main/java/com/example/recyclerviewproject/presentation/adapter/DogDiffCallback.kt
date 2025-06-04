package com.example.recyclerviewproject.adapterAux

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerviewproject.data.model.DogResponse

class DogDiffCallback : DiffUtil.ItemCallback<DogResponse>() {
    override fun areItemsTheSame(oldItem: DogResponse, newItem: DogResponse): Boolean =
        oldItem.imageUrl == newItem.imageUrl

    override fun areContentsTheSame(oldItem: DogResponse, newItem: DogResponse): Boolean =
        oldItem == newItem
}