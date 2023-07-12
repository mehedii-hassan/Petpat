package com.example.petpatandroidappdemo.models.response

data class LoginResponseModel(
    val `data`: Data,
    val message: String,
    val success: Boolean
) {
    data class Data(
        val access_token: String,
        val phone: String,
        val refresh_token: String,
        val service_provider_id: Any,
        val user_id: Int,
        val user_profile_id: Int
    )
}