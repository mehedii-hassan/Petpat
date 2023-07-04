package com.example.petpatandroidappdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.databinding.RvAddProductItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvBeautyServiceItemBinding
import com.example.petpatandroidappdemo.databinding.RvManageServicesItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvProductsItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvReviewItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvServicesItemDesignBinding

class AddProductAdapter(private val list: ArrayList<Int>) :
    RecyclerView.Adapter<AddProductAdapter.AddProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddProductViewHolder {
        val binding = RvAddProductItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AddProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: AddProductViewHolder, position: Int) {


    }


    inner class AddProductViewHolder(val binding: RvAddProductItemDesignBinding) :
        ViewHolder(binding.root) {

    }

}