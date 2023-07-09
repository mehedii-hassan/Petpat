package com.example.petpatandroidappdemo.callbacks

import com.example.petpatandroidappdemo.databinding.RvManageServicesItemDesignBinding

interface ManageServicesItemClickListener {
    fun getManageServicesItemDesignBindingInstance(position: Int, binding: RvManageServicesItemDesignBinding)
    fun getManageServicesAdapterPosition(position: Int)
}