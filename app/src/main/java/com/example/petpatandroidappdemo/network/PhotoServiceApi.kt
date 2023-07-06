package com.example.petpatandroidappdemo.network

import com.example.petpatandroidappdemo.models.AddProductModel
import com.example.petpatandroidappdemo.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Headers

interface PhotoServiceApi {


    @GET("/items")
    suspend fun getPhotos(): List<AddProductModel.Image>
/*@Headers("Authorization: Client-ID "+ Constants.PHOTOS_API_KEY)
    @GET("photos")
    Call<List<ImageModel>> getPhotos(
            @Query("page") int page,
            @Query("per_page") int perPage
    );*/

}