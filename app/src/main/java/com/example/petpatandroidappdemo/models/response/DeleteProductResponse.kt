package com.example.petpatandroidappdemo.models.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DeleteProductResponse(
    val message: String,
    val success: Boolean
) : Parcelable