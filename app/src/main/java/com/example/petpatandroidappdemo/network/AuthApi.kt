package com.example.petpatandroidappdemo.network

import com.example.petpatandroidappdemo.models.request.LoginRequestModel
import com.example.petpatandroidappdemo.models.response.LoginResponseModel
import com.example.petpatandroidappdemo.models.unsplashapimodel.PhotoModel
import com.example.petpatandroidappdemo.utils.Constants
import retrofit2.Call
import retrofit2.http.*

interface AuthApi {



    @POST("/api/v1/auth/login")
    fun userLogin(@Body loginRequestModel: LoginRequestModel): Call<LoginResponseModel>

}