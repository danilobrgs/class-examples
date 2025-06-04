package com.example.recyclerviewproject.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewproject.data.DogRepository
import com.example.recyclerviewproject.data.model.DogResponse
import kotlinx.coroutines.launch

class DogViewModel(
    private val repository: DogRepository
) : ViewModel() {

    private val _dogList = MutableLiveData<List<DogResponse>>(emptyList())
    val dogList: LiveData<List<DogResponse>> get() = _dogList

    fun fetchRandomDog() {
        viewModelScope.launch {
            try {
                val dog = repository.getRandomDog()
                dog?.let {
                    val updatedList = _dogList.value.orEmpty().toMutableList()
                    updatedList.add(it)
                    _dogList.value = updatedList
                }
            } catch (e: Exception) {
                // log error
            }
        }
    }
}