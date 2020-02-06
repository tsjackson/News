package com.example.pshodonewsapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pshodonewsapp.api.ApiService
import com.example.pshodonewsapp.data.NewsDataClass
import com.example.pshodonewsapp.util.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CustomViewModel:ViewModel() {
    val localData = MutableLiveData<NewsDataClass>()

    fun getData(){
        ApiService.getNewsResults.getTopNews("us",API_KEY).enqueue(object: Callback<NewsDataClass>{
            override fun onFailure(call: Call<NewsDataClass>, t: Throwable) {
                Log.d("Fail","$call, $t")
            }

            override fun onResponse(call: Call<NewsDataClass>, response: Response<NewsDataClass>) {
                localData.value = response.body()
                 Log.d("Response","$call, $response")
            }

        })
    }
    fun getLiveData():LiveData<NewsDataClass>{
        return localData
    }
}