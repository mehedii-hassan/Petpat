package com.example.petpatandroidappdemo.callbacks

import com.example.petpatandroidappdemo.databinding.RvMyServicesItemDesignBinding

interface ManageServicesItemClickListener {
    fun getManageServicesItemDesignBindingInstance(
        position: Int,
        binding: RvMyServicesItemDesignBinding
    )

    fun getManageServicesAdapterPosition(position: Int)
}