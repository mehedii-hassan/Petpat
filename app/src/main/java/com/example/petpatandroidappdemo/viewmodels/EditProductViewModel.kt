package com.example.petpatandroidappdemo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.petpatandroidappdemo.models.response.EditProductResponse
import com.example.petpatandroidappdemo.network.RetrofitClient
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProductViewModel(application: Application) : AndroidViewModel(application) {

    private val editProductResponse = MutableLiveData<EditProductResponse>()
    private val updateProductResponse = MutableLiveData<EditProductResponse>()

    fun getUpdateProductResponse(id: Int): LiveData<EditProductResponse> {
        loadData(id)
        return editProductResponse
    }

    fun getUpdateResponse(
        token: String,
        id: Int,
        productName: MultipartBody.Part,
        productPrice: MultipartBody.Part,
        imageList: ArrayList<MultipartBody.Part>
    ): LiveData<EditProductResponse> {
        loadUpdateData(token, id, productName, productPrice, imageList)
        return updateProductResponse
    }

    private fun loadUpdateData(
        token: String,
        id: Int,
        productName: MultipartBody.Part,
        productPrice: MultipartBody.Part,
        imageList: ArrayList<MultipartBody.Part>
    ) {

        RetrofitClient.getService().updateProduct(token, id, productName, productPrice, imageList)
            .enqueue(object : Callback<EditProductResponse> {
                override fun onResponse(
                    call: Call<EditProductResponse>,
                    response: Response<EditProductResponse>
                ) {
                    Log.e("TAG", "update error ${response.errorBody()}")

                    if (response.isSuccessful) {
                        updateProductResponse.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<EditProductResponse>, t: Throwable) {
                    Log.e("TAG", "update error ${t.localizedMessage}")

                }
            })

    }

    private fun loadData(id: Int) {

        RetrofitClient.getService().getEditProductItemResponse(id)
            .enqueue(object : Callback<EditProductResponse> {
                override fun onResponse(
                    call: Call<EditProductResponse>,
                    response: Response<EditProductResponse>
                ) {
                    if (response.isSuccessful) {
                        editProductResponse.postValue(response.body())
                        Log.e("TAG", "EditResponse success ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<EditProductResponse>, t: Throwable) {
                    Log.e("TAG", "EditResponse error ${t.localizedMessage}")
                }
            })
    }

}