package com.example.petpatandroidappdemo.network.PhotoService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getService(): PhotoServiceApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(PhotoServiceApi::class.java)
    }

  /*  val retrofit = Retrofit.Builder()
        .baseUrl("https://api.unsplash.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    val service = retrofit.create(PhotoServiceApi::class.java)
*/

}