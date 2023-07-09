package com.example.petpatandroidappdemo.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.models.gallery.PhotoModel
import com.example.petpatandroidappdemo.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaginationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        Log.e("TAG", "before ")


        ApiClient.getService().getImages(1, 10).enqueue(object : Callback<List<PhotoModel>> {
            override fun onResponse(
                call: Call<List<PhotoModel>>,
                response: Response<List<PhotoModel>>
            ) {
                Log.e("TAG", "out " + response.body())

                if (response.body() != null) {
                    Log.e("TAG", "successfull " + response.body())
                }

            }

            override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
                Log.e("TAG", "fail " + t.localizedMessage)

            }
        })

        Log.e("TAG", "after ")

        return inflater.inflate(R.layout.fragment_pagination, container, false)
    }

}