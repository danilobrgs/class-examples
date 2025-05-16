package com.example.recyclerviewproject.adapterAux

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerviewproject.model.Fruit

class FruitDiffCallback : DiffUtil.ItemCallback<Fruit>() {
    override fun areItemsTheSame(oldItem: Fruit, newItem: Fruit): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Fruit, newItem: Fruit): Boolean =
        oldItem == newItem
}