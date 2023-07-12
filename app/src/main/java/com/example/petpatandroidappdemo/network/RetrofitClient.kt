package com.example.petpatandroidappdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun getService(): AuthServiceApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://178.128.207.239:8010")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(AuthServiceApi::class.java)
    }

}