package com.example.petpatandroidappdemo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.petpatandroidappdemo.models.request.LoginRequestModel
import com.example.petpatandroidappdemo.models.response.LoginResponseModel
import com.example.petpatandroidappdemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val loginResponse = MutableLiveData<LoginResponseModel>()

    fun getLoginResponseModel(): LiveData<LoginResponseModel> {
        return loginResponse

    }

    fun getLoginResponseData(loginRequest: LoginRequestModel) {
        loadData(loginRequest)
    }

    private fun loadData(loginRequest: LoginRequestModel) {
        RetrofitClient.getService().userLogin(loginRequest)
            .enqueue(object : Callback<LoginResponseModel> {
                override fun onResponse(
                    call: Call<LoginResponseModel>,
                    response: Response<LoginResponseModel>
                ) {
                    if (response.isSuccessful) {
                        loginResponse.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                    Log.e("TAG", "fail ${t.localizedMessage}")
                }

            })

    }

}