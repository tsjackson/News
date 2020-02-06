package com.example.pshodonewsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pshodonewsapp.R
import com.example.pshodonewsapp.data.NewsDataClass
import com.example.pshodonewsapp.viewModel.CustomViewModel

class MainActivity : AppCompatActivity() {
     lateinit var viewModel: CustomViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, object: ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CustomViewModel() as T
            }
        }).get(CustomViewModel::class.java)

        viewModel.getData()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,1)

        viewModel.getLiveData().observe(this,object:Observer<NewsDataClass>{
            override fun onChanged(t: NewsDataClass?) {
                recyclerView.adapter = MyBaseAdapter(t)
            }
        })
    }
}
