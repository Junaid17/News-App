package com.example.myapplication.di.components

import com.example.myapplication.MainActivity
import com.example.myapplication.di.modules.ContextModule
import com.example.myapplication.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ContextModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}