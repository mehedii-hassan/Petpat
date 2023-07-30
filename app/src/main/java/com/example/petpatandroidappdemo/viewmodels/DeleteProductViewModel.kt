package com.example.petpatandroidappdemo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.petpatandroidappdemo.models.response.AddProductResponseModel
import com.example.petpatandroidappdemo.models.response.DeleteProductResponse
import com.example.petpatandroidappdemo.network.RetrofitClient
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeleteProductViewModel(application: Application) : AndroidViewModel(application) {
    private val deleteProductResponse = MutableLiveData<DeleteProductResponse>()

    fun getDeleteProductResponse(
        token: String,
        id: Int
    ): LiveData<DeleteProductResponse> {

        loadData(token, id)

        return deleteProductResponse
    }

    private fun loadData(
        token: String,
        id: Int
    ) {

        RetrofitClient.getService()
            .deleteProduct(token, id).enqueue(object : Callback<DeleteProductResponse> {
                override fun onResponse(
                    call: Call<DeleteProductResponse>,
                    response: Response<DeleteProductResponse>
                ) {
                    if (response.isSuccessful) {
                        deleteProductResponse.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DeleteProductResponse>, t: Throwable) {
                    Log.e("TAG", "delete failed ${t.localizedMessage}")
                }
            })

    }

}