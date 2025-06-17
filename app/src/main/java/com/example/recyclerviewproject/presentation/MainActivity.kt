package com.example.recyclerviewproject.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.adapterAux.BrandsAdapter
import com.example.recyclerviewproject.data.FipeRepository
import com.example.recyclerviewproject.data.remote.RetrofitClient
import com.example.recyclerviewproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: DogViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = FipeRepository(RetrofitClient.service)
                return DogViewModel(repository) as T
            }
        }
    }

    private val adapter = BrandsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        setObservers()

        viewModel.fetchBrands()
    }

    private fun setObservers() {
        viewModel.brands.observe(this) { dogs ->
            adapter.submitList(dogs.toList())
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
