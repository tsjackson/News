package com.example.pshodonewsapp.api

import com.example.pshodonewsapp.data.NewsDataClass
import com.example.pshodonewsapp.util.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface WeatherInterface {
    @Headers("country:us", API_KEY)
    @GET("/top-headlines")
    fun getTopNews() : Call<NewsDataClass>
}