package com.example.petpatandroidappdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.callbacks.ManageServicesItemClickListener
import com.example.petpatandroidappdemo.databinding.RvManageServicesItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvReviewItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvServicesItemDesignBinding

class MyServicesAdapter(private val list: ArrayList<Int>, fragment: Fragment) :
    RecyclerView.Adapter<MyServicesAdapter.MyServiceViewHolder>() {

    private val itemClickListener = fragment as ManageServicesItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyServiceViewHolder {
        val binding = RvManageServicesItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyServiceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun deleteItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }


    override fun onBindViewHolder(holder: MyServiceViewHolder, position: Int) {
        holder.bind(position)


    }


    inner class MyServiceViewHolder(val binding: RvManageServicesItemDesignBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {

            itemView.setOnClickListener {
                itemClickListener.getManageServicesAdapterPosition(position)
            }
            binding.tvProfessional.setOnClickListener {
                itemClickListener.getManageServicesItemDesignBindingInstance(position, binding)
            }
            binding.cvItemServices.setOnClickListener {
                itemClickListener.getManageServicesItemDesignBindingInstance(position, binding)
            }
        }


    }

}