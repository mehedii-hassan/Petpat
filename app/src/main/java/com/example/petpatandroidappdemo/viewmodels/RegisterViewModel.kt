package com.example.petpatandroidappdemo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.petpatandroidappdemo.models.request.RegisterRequestModel
import com.example.petpatandroidappdemo.models.response.RegisterResponseModel
import com.example.petpatandroidappdemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel(private val application: Application) : AndroidViewModel(application) {

    private val registerResponseModel = MutableLiveData<RegisterResponseModel>()

    fun getRegisterResponseModel(): LiveData<RegisterResponseModel> {
        return registerResponseModel

    }

    fun getRegisterResponseData(registerRequestModel: RegisterRequestModel) {
        loadData(registerRequestModel)
    }

    private fun loadData(registerRequestModel: RegisterRequestModel) {
        RetrofitClient.getService().userRegister(registerRequestModel)
            .enqueue(object : Callback<RegisterResponseModel> {
                override fun onResponse(
                    call: Call<RegisterResponseModel>,
                    response: Response<RegisterResponseModel>
                ) {
                    if (response.isSuccessful) {
                        registerResponseModel.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
                    Log.e("TAG", "fail ${t.localizedMessage}")
                }

            })
    }

}