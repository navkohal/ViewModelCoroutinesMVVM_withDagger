package com.example.coroutineswithmvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineswithmvvm.models.Products
import com.example.coroutineswithmvvm.repository.ProductRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * Created by Navdeep Singh Kohal on 28,June,2022
 */
class MainViewModel(private val repository : ProductRepo): ViewModel() {

    val productsLiveData: LiveData<List<Products>>
    get() = repository.products

    init {
        viewModelScope.launch{
            repository.getProducts()
        }

    }


}