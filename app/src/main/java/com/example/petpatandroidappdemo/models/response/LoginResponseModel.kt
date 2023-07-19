package com.example.petpatandroidappdemo.models.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class LoginResponseModel(
    val `data`: Data,
    val message: String,
    val success: Boolean
) : Parcelable {
    @Parcelize
    data class Data(
        val access_token: String,
        val phone: String,
        val refresh_token: String,
        val service_provider_id: @RawValue Any,
        val user_id: Int,
        val user_profile_id: Int
    ) : Parcelable
}