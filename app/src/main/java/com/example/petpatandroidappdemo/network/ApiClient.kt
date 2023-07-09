package com.example.petpatandroidappdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getService(): PhotoServiceApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/photos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(PhotoServiceApi::class.java)
    }
    /* public static PhotoServiceApi getService() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(PhotoServiceApi.class);
    }*/
}