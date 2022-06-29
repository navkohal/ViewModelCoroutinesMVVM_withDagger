package com.example.coroutineswithmvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coroutineswithmvvm.repository.ProductRepo
import javax.inject.Inject

/**
 * Created by Navdeep Singh Kohal on 28,June,2022
 */
class MainViewModelFactory @Inject constructor(private val repository : ProductRepo) : ViewModelProvider.Factory {

    //after creating this file , add below line in app.gradle file
    //****** freeCompilerArgs = ['-Xjvm-default=enable']

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}