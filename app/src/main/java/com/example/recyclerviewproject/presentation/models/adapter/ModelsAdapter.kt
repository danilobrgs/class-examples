package com.example.recyclerviewproject.adapterAux

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerviewproject.data.model.ModelResponse
import com.example.recyclerviewproject.databinding.ItemBrandBinding

class ModelsAdapter(onClickListener: (String) -> Unit) : ListAdapter<ModelResponse.ModelItemResponse, ModelsViewHolder>(ModelsDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelsViewHolder {
        val binding = ItemBrandBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModelsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModelsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
