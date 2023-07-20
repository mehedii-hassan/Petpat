package com.example.petpatandroidappdemo.models.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class AddProductResponseModel(
    val `data`: Data,
    val message: String,
    val success: Boolean
) : Parcelable {
    @Parcelize
    data class Data(
        val id: Int,
        val images: List<Image>,
        val name: String,
        val price: String,
        val product_count: @RawValue Any
    ) : Parcelable

    @Parcelize
    data class Image(
        val id: Int,
        val image: String
    ) : Parcelable
}