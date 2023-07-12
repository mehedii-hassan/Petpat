package com.example.petpatandroidappdemo.network

import com.example.petpatandroidappdemo.models.request.LoginRequestModel
import com.example.petpatandroidappdemo.models.request.OtpRequestModel
import com.example.petpatandroidappdemo.models.request.RegisterRequestModel
import com.example.petpatandroidappdemo.models.response.LoginResponseModel
import com.example.petpatandroidappdemo.models.response.OtpResponseModel
import com.example.petpatandroidappdemo.models.response.RegisterResponseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface AuthServiceApi {


    @POST("/api/v1/auth/login")
    fun userLogin(@Body loginRequestModel: LoginRequestModel): Call<LoginResponseModel>

    @POST("/api/v1/auth/user-register")
    fun userRegister(@Body registerRequestModel: RegisterRequestModel): Call<RegisterResponseModel>

    @POST("/api/v1/auth/verify-otp")
    fun verifyOTP(@Body otpRequestModel: OtpRequestModel): Call<OtpResponseModel>

    /* @POST("/api/v1/auth/verify-otp")
     suspend fun verifyOTP(
         @Body otpRequestModel: OtpRequestModel
     ): Response<OtpResponseModel>
 */
}