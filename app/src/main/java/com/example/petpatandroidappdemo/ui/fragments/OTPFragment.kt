package com.example.petpatandroidappdemo.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.denzcoskun.imageslider.animations.Toss
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentOTPBinding
import com.example.petpatandroidappdemo.models.request.OtpRequestModel
import com.example.petpatandroidappdemo.models.response.OtpResponseModel
import com.example.petpatandroidappdemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OTPFragment : Fragment() {


    private lateinit var binding: FragmentOTPBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOTPBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnContinue.setOnClickListener {
            verifyOTP()
        }
    }

    private fun verifyOTP() {
        val digitOne = binding.etOTP.text.toString()
        val digitTwo = binding.etOTPOne.text.toString()
        val digitThree = binding.etOTPTwo.text.toString()
        val digitFour = binding.etOTPThree.text.toString()
        val otpString = digitOne + digitTwo + digitThree + digitFour


        if (digitOne.isEmpty() || digitTwo.isEmpty() || digitThree.isEmpty() || digitFour.isEmpty()) {
            Toast.makeText(
                context,
                "Please fill up  all the OTP fields properly",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        RetrofitClient.getService().verifyOTP(OtpRequestModel(false, otpString, "01521321894"))
            .enqueue(object : Callback<OtpResponseModel> {
                override fun onResponse(
                    call: Call<OtpResponseModel>,
                    response: Response<OtpResponseModel>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(context, "Successfully Registered", Toast.LENGTH_SHORT)
                            .show()
                        Log.e("TAG", "success")
                        Navigation.findNavController(requireView()).navigate(R.id.loginFragment)
                    }

                }

                override fun onFailure(call: Call<OtpResponseModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

}