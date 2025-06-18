package com.example.recyclerviewproject.presentation.brands

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewproject.data.FipeRepository
import com.example.recyclerviewproject.data.model.BrandResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BrandsViewModel(
    private val repository: FipeRepository
) : ViewModel() {

    private val _brands = MutableLiveData<List<BrandResponse>>(emptyList())
    val brands: LiveData<List<BrandResponse>> get() = _brands
    private val _errorState = MutableLiveData<String>()
    val errorState: LiveData<String> get() = _errorState
    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> get() = _loadingState

    fun fetchBrands() {
        _loadingState.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val brands = repository.getBrands()
                brands?.let {
                    _brands.postValue(it)
                }
            } catch (e: Exception) {
                _errorState.postValue(e.message)
            }
            _loadingState.postValue(false)
        }
    }
}