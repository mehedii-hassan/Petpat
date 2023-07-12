package com.example.petpatandroidappdemo.models.request

data class OtpRequestModel(
    val is_forget_password: Boolean,
    val otp: String,
    val phone: String
)