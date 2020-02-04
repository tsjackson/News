package com.example.pshodonewsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pshodonewsapp.R
import com.example.pshodonewsapp.data.NewsDataClass
import com.example.pshodonewsapp.viewModel.CustomViewModel

class MainActivity : AppCompatActivity() {
    val customViewModel by lazy { ViewModelProvider(this, object : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CustomViewModel() as T
        }

    }).get(CustomViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customViewModel.getLiveData().observe(this,object: Observer<NewsDataClass>{
            override fun onChanged(t: NewsDataClass?) {
                t?.let { updateRecyclerView(it) }
            }
        })
        customViewModel.getData()
    }
    fun updateRecyclerView(dataSet: NewsDataClass){
        //TODO pass to the recyclerViewAdapter
    }
}
