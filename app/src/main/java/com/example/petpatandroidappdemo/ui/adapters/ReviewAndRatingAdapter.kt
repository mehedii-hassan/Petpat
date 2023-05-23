package com.example.petpatandroidappdemo.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.databinding.RvProductsItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvReviewItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvServicesItemDesignBinding

class ReviewAndRatingAdapter(private val list: ArrayList<Int>) :
    RecyclerView.Adapter<ReviewAndRatingAdapter.ReviewViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = RvReviewItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ReviewViewHolder(private val binding: RvReviewItemDesignBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.ivProfile.setImageResource(list[position])

        }
    }

}