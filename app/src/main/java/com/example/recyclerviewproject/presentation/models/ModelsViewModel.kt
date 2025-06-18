package com.example.recyclerviewproject.presentation.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewproject.data.FipeRepository
import com.example.recyclerviewproject.data.model.ModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ModelsViewModel(
    private val repository: FipeRepository
) : ViewModel() {

    private val _models = MutableLiveData<List<ModelResponse.ModelItemResponse>>(emptyList())
    val models: LiveData<List<ModelResponse.ModelItemResponse>> get() = _models

    private val _errorState = MutableLiveData<String>()
    val errorState: LiveData<String> get() = _errorState

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> get() = _loadingState

    fun fetchModels() {
        _loadingState.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val brands = repository.getModels("59")
                brands?.let {
                    _models.postValue(it)
                }
            } catch (e: Exception) {
                _errorState.postValue(e.message)
            }
            _loadingState.postValue(false)
        }
    }
}