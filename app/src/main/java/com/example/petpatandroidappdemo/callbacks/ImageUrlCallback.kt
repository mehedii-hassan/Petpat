package com.example.petpatandroidappdemo.callbacks

import com.example.petpatandroidappdemo.databinding.RvAddProductItemDesignBinding

interface ImageUrlCallback {
    fun getImageUrl(position: Int,url:String)
}