package com.example.recyclerviewproject.adapterAux

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerviewproject.data.model.BrandResponse
import com.example.recyclerviewproject.databinding.ItemBrandBinding

class BrandsAdapter(val onClickListener: (String) -> Unit) : ListAdapter<BrandResponse, BrandsViewHolder>(BrandsDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandsViewHolder {
        val binding = ItemBrandBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BrandsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandsViewHolder, position: Int) {
        holder.bind(getItem(position), onClickListener)
    }
}
