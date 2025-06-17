package com.example.recyclerviewproject.adapterAux

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerviewproject.data.model.BrandResponse

class BrandsDiffCallback : DiffUtil.ItemCallback<BrandResponse>() {
    override fun areItemsTheSame(oldItem: BrandResponse, newItem: BrandResponse): Boolean =
        oldItem.code == newItem.code

    override fun areContentsTheSame(oldItem: BrandResponse, newItem: BrandResponse): Boolean =
        oldItem == newItem
}