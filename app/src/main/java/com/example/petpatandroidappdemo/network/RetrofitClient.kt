package com.example.petpatandroidappdemo.network

import com.example.petpatandroidappdemo.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private  var token :String=""
    fun getToken(token:String){
        this.token=token

    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()


            // Add the token to the request header
            val requestBuilder = originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")

            val newRequest = requestBuilder.build()
            chain.proceed(newRequest)
        }
        .build()

    fun getService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://178.128.207.239:8010")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }


    /* val retrofit = Retrofit.Builder()
         .baseUrl("https://api.example.com/")
         .client(httpClient)
         .addConverterFactory(GsonConverterFactory.create())
         .build()

     val apiService = retrofit.create(ApiService::class.java)
 */
}