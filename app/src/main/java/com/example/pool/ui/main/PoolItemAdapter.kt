package com.example.pool.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pool.R
import kotlinx.android.synthetic.main.pool_status_item.view.*




class PoolItemAdapter(private val poolList: List<PoolStatusItem>): RecyclerView.Adapter<PoolItemAdapter.PoolItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoolItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.pool_status_item,
            parent, false)
        return PoolItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PoolItemViewHolder, position: Int) {
        val currentItem = poolList[position]
        holder.imageView.setImageResource(0)
        holder.titleView.text = currentItem.Title
        holder.description.text = currentItem.description
        holder.status.text = currentItem.poolStatus
    }


    override fun getItemCount() = poolList.size

    class PoolItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.icon_view
        val titleView: TextView = itemView.title_view1
        val description: TextView = itemView.description_1
        var status: TextView = itemView.pool_fill_in
    }
}