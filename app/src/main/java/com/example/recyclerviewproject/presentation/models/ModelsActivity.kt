package com.example.recyclerviewproject.presentation.models

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.adapterAux.ModelsAdapter
import com.example.recyclerviewproject.data.FipeRepository
import com.example.recyclerviewproject.data.remote.RetrofitClient
import com.example.recyclerviewproject.databinding.ActivityModelsBinding

class ModelsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityModelsBinding

    private val viewModel: ModelsViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = FipeRepository(RetrofitClient.service)
                return ModelsViewModel(repository) as T
            }
        }
    }

    private val adapter = ModelsAdapter { code ->
        val intent = Intent(this, ModelsActivity::class.java)
        intent.putExtra("brandCode", code)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        setObservers()

        viewModel.fetchModels()
    }

    private fun setObservers() {
        viewModel.models.observe(this) { models ->
            adapter.submitList(models.toList())
        }

        viewModel.errorState.observe(this) { errorMessage ->
            println(errorMessage)
        }

        viewModel.loadingState.observe(this) { isLoading ->
            if (isLoading)
                println("Está em loading")
            else
                println("Terminou o loading")
        }
    }

    private fun setupRecycler() {
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }
}