package com.example.coroutineswithmvvm.di

import com.example.coroutineswithmvvm.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Navdeep Singh Kohal on 28,June,2022
 */

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}