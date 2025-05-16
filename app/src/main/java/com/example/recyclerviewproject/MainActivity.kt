package com.example.recyclerviewproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.adapterAux.Fruit
import com.example.recyclerviewproject.adapterAux.FruitAdapter
import com.example.recyclerviewproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nomes = mutableListOf("Danilo", " Larissa", " Guilherme")

        nomes.forEach { nome ->
            println(nome)
        }


        nomes.forEachIndexed { index, nome ->
            println(nome + " $index")
        }


    }
}






































//val fruits = listOf(
//    Fruit(
//        "Banana",
//        "https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg"
//    ),
//    Fruit("Maçã", "https://upload.wikimedia.org/wikipedia/commons/1/15/Red_Apple.jpg"),
//    Fruit(
//        "Laranja",
//        "https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg"
//    )
//)
//
//val adapter = FruitAdapter()
//binding.rvFruits.layoutManager = LinearLayoutManager(this)
//binding.rvFruits.adapter = adapter
//adapter.submitList(fruits)