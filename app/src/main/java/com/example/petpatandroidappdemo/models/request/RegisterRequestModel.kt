package com.example.petpatandroidappdemo.models.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisterRequestModel(
    val first_name: String,
    val last_name: String,
    val password: String,
    val phone: String,
    val email: String
) : Parcelable