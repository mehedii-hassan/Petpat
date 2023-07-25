package com.example.petpatandroidappdemo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.petpatandroidappdemo.models.response.AddProductResponseModel
import com.example.petpatandroidappdemo.network.RetrofitClient
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddProductViewModel(application: Application) : AndroidViewModel(application) {
    private val addProductResponse = MutableLiveData<AddProductResponseModel>()

    fun getAddProductResponse(
        token: String,
        productName: MultipartBody.Part,
        productPrice: MultipartBody.Part,
        imageList: List<MultipartBody.Part>
    ): LiveData<AddProductResponseModel> {

        loadData(token, productName, productPrice, imageList)

        return addProductResponse
    }

    private fun loadData(
        token: String,
        productName: MultipartBody.Part,
        productPrice: MultipartBody.Part,
        imageList: List<MultipartBody.Part>
    ) {

        RetrofitClient.getService()
            .postImage(token, productName, productPrice, imageList)
            .enqueue(object : Callback<AddProductResponseModel> {
                override fun onResponse(
                    call: Call<AddProductResponseModel>,
                    response: Response<AddProductResponseModel>
                ) {
                    if (response.isSuccessful) {
                        addProductResponse.postValue(response.body())
                    }
                    Log.e(
                        "TAG",
                        "response ${response.body()} size ${imageList.size}"
                    )
                }

                override fun onFailure(call: Call<AddProductResponseModel>, t: Throwable) {
                    Log.e("TAG", "error ${t.message}")
                }
            })
    }

}