package com.example.pshodonewsapp.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pshodonewsapp.R

class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
    val newsImg : ImageView
    val newsAuthor: TextView
    val newsTitle: TextView
    val newsSource: TextView
    init {
        newsImg = itemView.findViewById(R.id.iv_newsImages)
        newsAuthor = itemView.findViewById(R.id.tv_author)
        newsTitle = itemView.findViewById(R.id.tv_title)
        newsSource = itemView.findViewById(R.id.tv_source)
    }
}