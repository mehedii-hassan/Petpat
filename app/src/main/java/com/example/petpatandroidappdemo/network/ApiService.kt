package com.example.petpatandroidappdemo.network

import com.example.petpatandroidappdemo.models.request.Image
import com.example.petpatandroidappdemo.models.request.LoginRequestModel
import com.example.petpatandroidappdemo.models.request.OtpRequestModel
import com.example.petpatandroidappdemo.models.request.RegisterRequestModel
import com.example.petpatandroidappdemo.models.response.AddProductResponseModel
import com.example.petpatandroidappdemo.models.response.DataResponse
import com.example.petpatandroidappdemo.models.response.LoginResponseModel
import com.example.petpatandroidappdemo.models.response.OtpResponseModel
import com.example.petpatandroidappdemo.models.response.RegisterResponseModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {


    @POST("/api/v1/auth/login")
    fun userLogin(@Body loginRequestModel: LoginRequestModel): Call<LoginResponseModel>

    @POST("/api/v1/auth/user-register")
    fun userRegister(@Body registerRequestModel: RegisterRequestModel): Call<RegisterResponseModel>

    @POST("/api/v1/auth/verify-otp")
    fun verifyOTP(@Body otpRequestModel: OtpRequestModel): Call<OtpResponseModel>

    @FormUrlEncoded
    @POST("/api/v1/product/add")
    fun addProduct(
        @Header("Authorization") token: String,
        @Field("name") name: String,
        @Field("price") price: String,
        @Field("imageUris") imageUris: RequestBody
    ): Call<AddProductResponseModel>
    /*
    @POST("/api/v1/product/add")
        fun addProduct(
            @Header("Authorization") token: String,
            @Body addProductRequestModel: AddProductRequestModel,
        ): Call<AddProductResponseModel>
    */

    @GET("/api/v1/issue/admin-issue-categories")
    fun getData(
        @Header("Authorization") token: String
    ): Call<DataResponse>


    /* @POST("/api/v1/auth/verify-otp")
     suspend fun verifyOTP(
         @Body otpRequestModel: OtpRequestModel
     ): Response<OtpResponseModel>
 */
}