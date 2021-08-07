package com.example.pool.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pool.R
import com.example.pool.dto.ProductAndImage
import kotlinx.android.synthetic.main.product_report.view.*

class ProductItemAdapter(private val productList: Array<ProductAndImage?>): RecyclerView.Adapter<ProductItemAdapter.ProductItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.product_report,
            parent, false)
        return ProductItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.imageView.setImageResource(currentItem!!.getImage())
        holder.titleView.text = currentItem!!.getTitle()
        holder.description.text = currentItem.getLink()
        holder.status.text = currentItem.getRaw()
    }


    override fun getItemCount() = productList.size

    class ProductItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.productView
        val titleView: TextView = itemView.lblTitle
        val description: TextView = itemView.lblLink
        var status: TextView = itemView.lblPrice
    }
}