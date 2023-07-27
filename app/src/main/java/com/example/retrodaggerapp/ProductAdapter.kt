package com.example.retrodaggerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrodaggerapp.datamodels.Product

class ProductAdapter(val context: Context, val productList: List<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var productImageView = itemView.findViewById<ImageView>(R.id.productImageView)
        var productTitleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        var priceTextView = itemView.findViewById<TextView>(R.id.priceTextView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
       return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product:Product = productList[position]
        holder.productTitleTextView.text = product.title
        holder.priceTextView.text = product.price.toString()
        Glide.with(context).load(product.image).into(holder.productImageView)
    }

}


