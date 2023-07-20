package com.example.petpatandroidappdemo.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.petpatandroidappdemo.models.response.ProductsResponse
import com.example.petpatandroidappdemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel(application: Application) : AndroidViewModel(application) {

    private val productsResponse = MutableLiveData<ProductsResponse>()

    fun getProductsResponse(id: Int): LiveData<ProductsResponse> {
        loadData(id)
        return productsResponse
    }

    private fun loadData(id: Int) {

        RetrofitClient.getService().getProductsList(id)
            .enqueue(object : Callback<ProductsResponse> {
                override fun onResponse(
                    call: Call<ProductsResponse>,
                    response: Response<ProductsResponse>
                ) {
                    if (response.isSuccessful) {
                        productsResponse.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

}