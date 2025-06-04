package com.example.recyclerviewproject.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.adapterAux.DogAdapter
import com.example.recyclerviewproject.data.DogRepository
import com.example.recyclerviewproject.data.remote.RetrofitClient
import com.example.recyclerviewproject.databinding.ActivityMainBinding
import com.example.recyclerviewproject.data.model.DogResponse
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: DogViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = DogRepository(RetrofitClient.service)
                return DogViewModel(repository) as T
            }
        }
    }

    private val adapter = DogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter

        binding.btNewDog.setOnClickListener {
            viewModel.fetchRandomDog()
        }

        viewModel.dogList.observe(this) { dogs ->
            adapter.submitList(dogs.toList())
        }
    }
}
