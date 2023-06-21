package com.example.petpatandroidappdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.databinding.RvProductsItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvServicesItemDesignBinding

class ProductsAdapter(private val list: ArrayList<Int>) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = RvProductsItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ProductsViewHolder(private val binding: RvProductsItemDesignBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.ivProductsItem.setImageResource(list[position])

        }
    }

}