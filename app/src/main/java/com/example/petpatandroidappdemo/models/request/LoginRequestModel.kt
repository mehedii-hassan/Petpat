package com.example.petpatandroidappdemo.models.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequestModel(
    val phone: String,
    val password: String
) : Parcelable