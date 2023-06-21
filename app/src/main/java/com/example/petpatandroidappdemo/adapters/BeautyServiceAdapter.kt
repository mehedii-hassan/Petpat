package com.example.petpatandroidappdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.databinding.RvBeautyServiceItemBinding
import com.example.petpatandroidappdemo.databinding.RvProductsItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvReviewItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvServicesItemDesignBinding

class BeautyServiceAdapter(private val list: ArrayList<String>) :
    RecyclerView.Adapter<BeautyServiceAdapter.BeautyServiceViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeautyServiceViewHolder {
        val binding = RvBeautyServiceItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BeautyServiceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BeautyServiceViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class BeautyServiceViewHolder(private val binding: RvBeautyServiceItemBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.tvBraids.text = list[position]

        }
    }

}