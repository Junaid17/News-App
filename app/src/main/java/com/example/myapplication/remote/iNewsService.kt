package com.example.myapplication.remote

import com.example.myapplication.model.NewsResponseModel
import io.reactivex.Single
import retrofit2.http.GET

interface iNewsService {

    @GET("/v2/top-headlines?country=us&apiKey=26225f12a7df4907b4d183638a2adc06")
    fun getTopHeadlines(): Single<NewsResponseModel>
}