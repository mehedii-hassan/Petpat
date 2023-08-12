package com.example.petpatandroidappdemo.models.response

data class AddNewServicesResponse(
    val count: Int,
    val `data`: List<Data>,
    val links: Links,
    val messsage: String,
    val success: Boolean
) {
    data class Links(
        val next: Any,
        val previous: Any
    )

    data class Data(
        val id: Int,
        val image: String,
        val name: String,
        val name_ar: String
    )
}