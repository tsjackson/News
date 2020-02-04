package com.example.pshodonewsapp.api

import com.example.pshodonewsapp.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService{
    fun newsFeed(): OkHttpClient = OkHttpClient.Builder().build()

    fun getRetrofit():Retrofit = Retrofit.Builder()
        .client(newsFeed())
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val getNewsResults: WeatherInterface = getRetrofit().create(WeatherInterface::class.java)
}