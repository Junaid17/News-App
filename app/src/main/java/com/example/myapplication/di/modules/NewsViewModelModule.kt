package com.example.myapplication.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.di.NewsViewModelKey
import com.example.myapplication.viewmodel.NewsViewModel
import com.example.myapplication.viewmodel.NewsViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewsViewModelModule {

    @Binds
    @IntoMap
    @NewsViewModelKey(NewsViewModel::class)
    abstract fun bindsViewModel(newsViewModel: NewsViewModel):ViewModel

    @Binds
    abstract fun bindFactory(viewModelFactory: NewsViewModelFactory) :ViewModelProvider.Factory
}