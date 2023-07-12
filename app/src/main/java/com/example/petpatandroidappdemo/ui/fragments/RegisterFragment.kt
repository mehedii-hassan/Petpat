package com.example.petpatandroidappdemo.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentRegisterBinding
import com.example.petpatandroidappdemo.models.request.RegisterRequestModel
import com.example.petpatandroidappdemo.models.response.RegisterResponseModel
import com.example.petpatandroidappdemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {


    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnRegister.setOnClickListener {
            userRegister()
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

        }
    }

    private fun userRegister() {
        val fName = binding.etFirstName.text.toString()
        val lName = binding.etLastName.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPass = binding.etConfirmPassword.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val emailOptional = binding.etEmailOptional.text.toString()

        val model = RegisterRequestModel(
            fName,
            lName,
            password,
            phoneNumber,
            emailOptional,
        )
        RetrofitClient.getService().userRegister(model).enqueue(object :
            Callback<RegisterResponseModel> {
            override fun onResponse(
                call: Call<RegisterResponseModel>,
                response: Response<RegisterResponseModel>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(context, "Successfully ready to otp verify", Toast.LENGTH_SHORT).show()
                    Log.e("TAG", "success")
                    Navigation.findNavController(requireView()).navigate(R.id.otpFragment)
                }
            }

            override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                Log.e("TAG", "error : ${t.localizedMessage}")


            }

        })

    }
}