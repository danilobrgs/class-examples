package com.example.recyclerviewproject.adapterAux

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewproject.R
import com.example.recyclerviewproject.data.model.DogResponse
import com.example.recyclerviewproject.databinding.ItemDogBinding

class DogViewHolder(private val binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DogResponse) {
        binding.tvName.text = item.imageUrl
        binding.tvPrice.text = "00"

        Glide.with(binding.ivIcon.context)
            .load(item.imageUrl)
            .placeholder(R.drawable.ic_ball)
            .into(binding.ivIcon)

        binding.root.setOnClickListener {

        }
    }
}