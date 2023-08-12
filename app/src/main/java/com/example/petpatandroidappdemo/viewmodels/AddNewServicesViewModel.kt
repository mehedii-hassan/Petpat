package com.example.petpatandroidappdemo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.petpatandroidappdemo.models.request.LoginRequestModel
import com.example.petpatandroidappdemo.models.response.AddNewServicesResponse
import com.example.petpatandroidappdemo.models.response.LoginResponseModel
import com.example.petpatandroidappdemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddNewServicesViewModel(application: Application) : AndroidViewModel(application) {

    private val addNewServicesResponse = MutableLiveData<AddNewServicesResponse>()

    fun getAddNewServicesResponse(): LiveData<AddNewServicesResponse> {
        loadData()
        return addNewServicesResponse

    }


    private fun loadData() {
        RetrofitClient.getService().getServiceProvidedList()
            .enqueue(object : Callback<AddNewServicesResponse> {
                override fun onResponse(
                    call: Call<AddNewServicesResponse>,
                    response: Response<AddNewServicesResponse>
                ) {

                    if (response.isSuccessful) {
                        addNewServicesResponse.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<AddNewServicesResponse>, t: Throwable) {

                    Log.e("TAG", "error ${t.message}")

                }
            })

    }

}