package com.example.recyclerviewproject.adapterAux

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproject.data.model.BrandResponse
import com.example.recyclerviewproject.data.model.ModelResponse
import com.example.recyclerviewproject.databinding.ItemBrandBinding

class ModelsViewHolder(private val binding: ItemBrandBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ModelResponse.ModelItemResponse) {
        binding.tvName.text = item.name
        binding.tvPrice.text = item.code.toString()

        binding.root.setOnClickListener {

        }
    }
}