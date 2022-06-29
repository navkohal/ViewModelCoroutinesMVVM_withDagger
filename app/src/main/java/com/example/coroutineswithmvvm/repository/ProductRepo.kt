package com.example.coroutineswithmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coroutineswithmvvm.models.Products
import com.example.coroutineswithmvvm.utils.ApiInterface
import javax.inject.Inject

/**
 * Created by Navdeep Singh Kohal on 28,June,2022
 */
class ProductRepo @Inject constructor(private val apiInterface: ApiInterface) {

    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>>
    get() = _products

    suspend fun getProducts(){
        val result = apiInterface.getProducts()
        if(result.isSuccessful && result.body()!=null){
            _products.postValue(result.body())
        }
    }
}