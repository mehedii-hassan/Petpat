package com.example.petpatandroidappdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.databinding.RvProductsItemDesignBinding
import com.example.petpatandroidappdemo.models.response.ProductsResponse

class ProductsAdapter(private val productsResponse: ProductsResponse) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = RvProductsItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsResponse.data[0].images.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ProductsViewHolder(private val binding: RvProductsItemDesignBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {

            binding.ivProductsItem.setImageURI(productsResponse.data[position].images[position].image.toUri())
            binding.tvPrice.text = productsResponse.data[position].price
            binding.tvName.text = productsResponse.data[position].name
        }
    }

}