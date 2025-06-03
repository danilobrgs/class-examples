package com.example.recyclerviewproject.adapterAux

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerviewproject.databinding.ItemFruitBinding
import com.example.recyclerviewproject.model.DogResponse
import com.example.recyclerviewproject.model.Fruit

class FruitAdapter : ListAdapter<DogResponse, FruitViewHolder>(FruitDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FruitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}