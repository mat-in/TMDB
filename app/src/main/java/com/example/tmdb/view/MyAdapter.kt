package com.example.tmdb.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.data.Movie
import com.example.tmdb.R

class MyAdapter(val itemsList: ArrayList<Movie>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        var itemImg: ImageView
        var itemTitle: TextView
        var itemDesc: TextView

        init {
            itemImg = itemView.findViewById(R.id.imageview)
            itemTitle = itemView.findViewById(R.id.title_txt)
            itemDesc = itemView.findViewById(R.id.description_text)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        Log.d("AdapterLog", "onCreateViewHolder called")
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(v)
    }
    override fun getItemCount(): Int {
        Log.d("AdapterLog", "getItemCalled called")
        return itemsList.size
        Log.d("size: ", "${itemsList.size}")
    }
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        Log.d("AdapterLog", "onBindViewHolder called")

        holder.itemTitle.setText(itemsList[position].title)
        holder.itemDesc.setText(itemsList[position].overview)
        var movie = itemsList[position]
        var posterUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
        Glide.with(holder.itemView.context)
            .load(posterUrl)
            .into(holder.itemImg)
    }

}