package com.example.pshodonewsapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.pshodonewsapp.R
import com.example.pshodonewsapp.data.NewsDataClass

class MyBaseAdapter (val dataSet:LiveData<NewsDataClass>): RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return dataSet.value?.articles?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.newsSource.text = dataSet.value?.articles?.get(position)?.content
        holder.newsTitle.text = dataSet.value?.articles?.get(position)?.title
        holder.newsAuthor.text = dataSet.value?.articles?.get(position)?.author
    }
}