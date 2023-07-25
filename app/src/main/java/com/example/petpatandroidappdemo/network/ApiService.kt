package com.example.petpatandroidappdemo.network

import com.example.petpatandroidappdemo.models.request.LoginRequestModel
import com.example.petpatandroidappdemo.models.request.OtpRequestModel
import com.example.petpatandroidappdemo.models.request.RegisterRequestModel
import com.example.petpatandroidappdemo.models.response.AddProductResponseModel
import com.example.petpatandroidappdemo.models.response.LoginResponseModel
import com.example.petpatandroidappdemo.models.response.OtpResponseModel
import com.example.petpatandroidappdemo.models.response.ProductsResponse
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

    @FormUrlEncoded
    @POST("/api/v1/product/add")
    fun addProductForSingleImage(
        @Header("Authorization") token: String,
        @Field("name") name: String,
        @Field("price") price: String,
        @Field("image") image: RequestBody
    ): Call<AddProductResponseModel>


    @FormUrlEncoded
    @POST("/api/v1/product/add")
    @JvmSuppressWildcards
    fun addProductForListOfImage(
        @Header("Authorization") token: String,
        @Field("name") name: String,
        @Field("price") price: String,
        @Field("image") images: List<String>
    ): Call<AddProductResponseModel>

    @GET("/api/v1/product/list/{id}")
    fun getProductsList(@Path("id") id: Int): Call<ProductsResponse>


    @Multipart
    @POST("/api/v1/product/add")
    fun postImage(
        @Header("Authorization") token: String,
        @Part name: MultipartBody.Part,
        @Part price: MultipartBody.Part,
        @Part image: List<MultipartBody.Part>
    ): Call<AddProductResponseModel>

    /* @Multipart
     @POST("upload/image")
     fun uploadImage(
         @Part imageFile: MultipartBody.Part
     ): Call<ImageUploadResponse>
 */
}