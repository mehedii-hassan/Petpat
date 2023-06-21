package com.example.petpatandroidappdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.databinding.RvBeautyServiceItemBinding
import com.example.petpatandroidappdemo.databinding.RvManageServicesItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvProductsItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvReviewItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvServicesItemDesignBinding

class MyServicesAdapter(private val list: ArrayList<Int>) :
    RecyclerView.Adapter<MyServicesAdapter.MyServiceViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyServiceViewHolder {
        val binding = RvManageServicesItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyServiceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: MyServiceViewHolder, position: Int) {
        // val item = items[position]
        // Set the image for the ImageView
        //holder.imageView.setImageResource(item.imageResource)

        // Set the click listener for the delete button
        holder.binding.cvTrash.setOnClickListener {
            // Delete the item from the list
            list.removeAt(position)
            notifyItemRemoved(position)
        }

    }


    inner class MyServiceViewHolder(val binding: RvManageServicesItemDesignBinding) :
        ViewHolder(binding.root) {

    }

}