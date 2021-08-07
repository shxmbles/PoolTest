package com.example.pool.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pool.R
import com.example.pool.dto.PoolResults
import com.example.pool.dto.ProductAndImage
import kotlinx.android.synthetic.main.chemical_report.view.*
import kotlinx.android.synthetic.main.product_report.view.*

class ResultItemAdapter(private val resultList: Array<PoolResults>): RecyclerView.Adapter<ResultItemAdapter.ResultItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.chemical_report,
            parent, false)
        return ResultItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ResultItemViewHolder, position: Int) {
        val currentItem = resultList[position]
        holder.titleView.text = currentItem!!.chemical.name
        holder.description.text = currentItem.message
    }


    override fun getItemCount() = resultList.size

    class ResultItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.chemlbl
        val description: TextView = itemView.lblLink
        var status: TextView = itemView.reportlbl
    }
}