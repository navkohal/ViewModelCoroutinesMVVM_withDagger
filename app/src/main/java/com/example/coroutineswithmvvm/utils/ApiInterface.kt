package com.example.coroutineswithmvvm.utils

import com.example.coroutineswithmvvm.models.Products
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Navdeep Singh Kohal on 28,June,2022
 */
interface ApiInterface {

    @GET("products")
    suspend fun getProducts() : Response<List<Products>>
}