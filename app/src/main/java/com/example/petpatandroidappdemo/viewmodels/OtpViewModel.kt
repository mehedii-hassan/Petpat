package com.example.petpatandroidappdemo.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.petpatandroidappdemo.models.request.OtpRequestModel
import com.example.petpatandroidappdemo.models.response.OtpResponseModel
import com.example.petpatandroidappdemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtpViewModel(private val application: Application) : AndroidViewModel(application) {

    private val otpResponseModel = MutableLiveData<OtpResponseModel>()

    fun getOtpResponseModel(): LiveData<OtpResponseModel> {
        return otpResponseModel

    }

    fun getOtpResponseData(otpRequestModel: OtpRequestModel) {
        loadData(otpRequestModel)
    }

    private fun loadData(otpRequestModel: OtpRequestModel) {
        RetrofitClient.getService().verifyOTP(otpRequestModel)
            .enqueue(object : Callback<OtpResponseModel> {
                override fun onResponse(
                    call: Call<OtpResponseModel>,
                    response: Response<OtpResponseModel>
                ) {
                    if (response.isSuccessful) {
                        otpResponseModel.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<OtpResponseModel>, t: Throwable) {
                    Log.e("TAG", "fail ${t.localizedMessage}")
                }
            })
    }

}