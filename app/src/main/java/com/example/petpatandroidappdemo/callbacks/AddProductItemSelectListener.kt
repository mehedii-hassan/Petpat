package com.example.petpatandroidappdemo.callbacks

import com.example.petpatandroidappdemo.databinding.RvAddProductItemDesignBinding

interface AddProductItemSelectListener {
    fun getAddProductItemPosition(position: Int,binding: RvAddProductItemDesignBinding)
}