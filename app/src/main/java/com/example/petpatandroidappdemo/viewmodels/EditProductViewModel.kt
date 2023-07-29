package com.example.petpatandroidappdemo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.petpatandroidappdemo.models.response.EditProductResponse
import com.example.petpatandroidappdemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProductViewModel(application: Application) : AndroidViewModel(application) {

    private val editProductResponse = MutableLiveData<EditProductResponse>()

    fun getUpdateProductResponse(id: Int): LiveData<EditProductResponse> {
        loadData(id)
        return editProductResponse
    }

    private fun loadData(id: Int) {

        RetrofitClient.getService().getEditProductList(id)
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