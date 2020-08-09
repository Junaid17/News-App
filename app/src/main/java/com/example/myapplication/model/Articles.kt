package com.example.myapplication.model

data class Articles(
    val sources:Source,
    val author:String,
    val title:String,
    val description:String,
    val url:String,
    val urlToImage:String,
    val publishedAt:String,
    val content:String
)