package com.example.pshodonewsapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pshodonewsapp.R

class MyBaseAdapter (val dataSet:List<String>): RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.newsSource.text = dataSet[position]
        holder.newsTitle.text = dataSet[position]
        holder.newsAuthor.text = dataSet[position]
    }
}