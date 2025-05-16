package com.example.recyclerviewproject.adapterAux

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewproject.R
import com.example.recyclerviewproject.databinding.ItemFruitBinding
import com.example.recyclerviewproject.model.Fruit

class FruitViewHolder(private val binding: ItemFruitBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Fruit) {
        binding.tvName.text = item.name

        Glide.with(binding.ivIcon.context)
            .load(item.imageUrl)
            .placeholder(R.drawable.ic_ball)
            .into(binding.ivIcon)
    }
}