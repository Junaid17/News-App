package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.NewsResponseModel
import com.example.myapplication.repository.NewsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver


import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsViewModel:ViewModel{

    private val newsRepository:NewsRepository
    val disposable=CompositeDisposable()
     private val newsResponseModelData: MutableLiveData<NewsResponseModel> = MutableLiveData<NewsResponseModel>()
     private  val isLoading = MutableLiveData<Boolean>()
     private val error = MutableLiveData<String>()
    @Inject
    constructor(newsRepository: NewsRepository){
        this.newsRepository=newsRepository
    }

    fun getModelMutableLiveData(): MutableLiveData<NewsResponseModel> {
        fetchData()
        return newsResponseModelData
    }

    private fun fetchData() {
        isLoading.value = true
        disposable.add(
            newsRepository.getNewsResponseModel()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NewsResponseModel>() {
                    override fun onSuccess(newsResponseModel: NewsResponseModel) {
                        isLoading.value = false
                        newsResponseModelData.value = newsResponseModel
                    }

                    override fun onError(e: Throwable) {
                        error.value = e.message
                        isLoading.value = false
                    }
                })
        )
    }

    fun getIsLoading(): MutableLiveData<Boolean> {
        return isLoading
    }

    fun getError(): MutableLiveData<String> {
        return error
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
