package com.example.petpatandroidappdemo.models.response

data class DataResponse(
    val count: Int,
    val `data`: List<Data>,
    val links: Links,
    val messsage: String,
    val success: Boolean
)