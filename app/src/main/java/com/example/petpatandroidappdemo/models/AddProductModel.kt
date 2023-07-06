package com.example.petpatandroidappdemo.models

data class AddProductModel(
    val `data`: Data,
    val message: String,
    val success: Boolean,

    ) {

    data class Data(
        val id: Int,
        val images: List<Image>,
        val name: String,
        val price: String,
        val product_count: Any
    )

    data class Image(
        val id: Int,
        val image: String
    )
}