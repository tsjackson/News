package com.example.pshodonewsapp.api

import com.example.pshodonewsapp.data.NewsDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {
    @GET("v2/top-headlines")
    fun getTopNews(@Query("country")country:String, @Query("apiKey")apiKey: String) : Call<NewsDataClass>
}