package com.example.recyclerviewproject.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproject.databinding.ItemFruitBinding
import com.example.recyclerviewproject.model.Fruit

class FruitViewHolder(private val binding: ItemFruitBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(fruit: Fruit) {
        binding.tvName.text = fruit.name
    }
}