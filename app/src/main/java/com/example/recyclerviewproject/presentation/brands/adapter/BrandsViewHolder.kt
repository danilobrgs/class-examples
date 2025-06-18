package com.example.recyclerviewproject.adapterAux

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproject.data.model.BrandResponse
import com.example.recyclerviewproject.databinding.ItemBrandBinding

class BrandsViewHolder(private val binding: ItemBrandBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: BrandResponse, onClickListener: (String) -> Unit) {
        binding.tvName.text = item.name
        binding.tvPrice.text = item.code

        binding.root.setOnClickListener {
            onClickListener.invoke(item.code)
        }
    }
}