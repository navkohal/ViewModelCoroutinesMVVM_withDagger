package com.example.coroutineswithmvvm

import android.app.Application
import com.example.coroutineswithmvvm.di.ApplicationComponent
import com.example.coroutineswithmvvm.di.DaggerApplicationComponent
import dagger.Component
/**
 * Created by Navdeep Singh Kohal on 28,June,2022
 */
class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}