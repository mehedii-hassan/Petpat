package com.example.petpatandroidappdemo.models.response

data class ProductsResponse(
    val count: Int,
    val `data`: List<Data>,
    val links: Links,
    val messsage: String,
    val success: Boolean
){
    data class Links(
        val next: Any,
        val previous: Any
    )

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