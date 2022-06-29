package com.example.coroutineswithmvvm.models

data class Products(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)