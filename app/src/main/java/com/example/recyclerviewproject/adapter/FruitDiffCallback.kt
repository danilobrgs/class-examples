package com.example.recyclerviewproject.adapterAux

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerviewproject.model.DogResponse
import com.example.recyclerviewproject.model.Fruit

class FruitDiffCallback : DiffUtil.ItemCallback<DogResponse>() {
    override fun areItemsTheSame(oldItem: DogResponse, newItem: DogResponse): Boolean =
        oldItem.imageUrl == newItem.imageUrl

    override fun areContentsTheSame(oldItem: DogResponse, newItem: DogResponse): Boolean =
        oldItem == newItem
}