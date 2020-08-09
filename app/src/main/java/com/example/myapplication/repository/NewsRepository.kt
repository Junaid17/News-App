package com.example.myapplication.repository

import com.example.myapplication.model.NewsResponseModel
import com.example.myapplication.remote.iNewsService
import io.reactivex.Single
import javax.inject.Inject

class NewsRepository {
    val iNewsService:iNewsService
    @Inject
    constructor(iNewsService: iNewsService){
        this.iNewsService=iNewsService
    }

    fun getNewsResponseModel(): Single<NewsResponseModel> {
        return iNewsService.getTopHeadlines()
    }

}