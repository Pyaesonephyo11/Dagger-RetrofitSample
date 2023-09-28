package com.example.daggerretro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daggerretro.databinding.RecyclerviewItemBinding
import com.example.daggerretro.model.JsonData

class RecyclerAdapter: RecyclerView.Adapter<MainViewHolder>() {
    private lateinit var data : List<JsonData>
    fun setData(data: List<JsonData>) {
        this.data = data
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = data[position]
        holder.binding.name.text = data.title.substring(0,10)
        Glide.with(holder.itemView.context).load(data.url).into(holder.binding.imageview)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}
class MainViewHolder(val binding:RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
}