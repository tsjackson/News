package com.example.pshodonewsapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pshodonewsapp.api.ApiService
import com.example.pshodonewsapp.data.NewsDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CustomViewModel:ViewModel() {
    private val localData = MutableLiveData<NewsDataClass>()

    fun getData(){
        ApiService.getNewsResults.getTopNews().enqueue(object: Callback<NewsDataClass>{
            override fun onFailure(call: Call<NewsDataClass>, t: Throwable) {
                Log.d("Failure","Call: $call, $t")
            }

            override fun onResponse(call: Call<NewsDataClass>, response: Response<NewsDataClass>) {
                //TODO send data to ui
                localData.value = response.body()
            }
        })
    }
    fun getLiveData():LiveData<NewsDataClass>{
        return localData
    }
}