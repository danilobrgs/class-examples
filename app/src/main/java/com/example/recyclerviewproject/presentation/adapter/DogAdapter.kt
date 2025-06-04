package com.example.recyclerviewproject.adapterAux

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerviewproject.data.model.DogResponse
import com.example.recyclerviewproject.databinding.ItemDogBinding

class DogAdapter : ListAdapter<DogResponse, DogViewHolder>(DogDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = ItemDogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}