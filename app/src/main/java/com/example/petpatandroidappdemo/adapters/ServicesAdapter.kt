package com.example.petpatandroidappdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.databinding.RvServicesItemDesignBinding

class ServicesAdapter(private val list: ArrayList<Int>) :
    RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val binding = RvServicesItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ServicesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ServicesViewHolder(private val binding: RvServicesItemDesignBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.ivServicesItem.setImageResource(list[position])

        }

    }
    /*inner class PopularProductViewHolder(private val binding: RvFeatureProductsItemDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.ivFeatureProductItem.setImageResource(featureProductImageList[position])


        }
    }*/
}