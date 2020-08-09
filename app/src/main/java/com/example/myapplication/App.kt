package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.components.AppComponent

class App : Application() {
    private var appComponent: AppComponent = null
    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerAppComponent.create()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

}