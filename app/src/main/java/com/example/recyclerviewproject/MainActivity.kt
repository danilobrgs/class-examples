package com.example.recyclerviewproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.adapterAux.FruitAdapter
import com.example.recyclerviewproject.databinding.ActivityMainBinding
import com.example.recyclerviewproject.model.DogResponse
import com.example.recyclerviewproject.model.Fruit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var dogs: MutableList<DogResponse> = mutableListOf()
    val adapter = FruitAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvFruits.layoutManager = LinearLayoutManager(this)
        binding.rvFruits.adapter = adapter

        binding.btNewDog.setOnClickListener {
            getRandomDog()
        }
    }

    private fun getRandomDog() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.service.getRandomDog()
                if (response.isSuccessful) {
                    val dog = response.body()
                    Log.d("Sucesso", dog?.imageUrl ?: "")
                    dog?.let {
                        dogs.add(dog)
                        adapter.submitList(dogs.toMutableList())
                    }
                } else {
                    Log.e("DOG_API", "Erro: ${response.code()}")
                    print("erro")
                }
            } catch (e: Exception) {
                Log.e("DOG_API", "Falha na chamada", e)
                print("erro 2")
            }
        }
    }
}





































