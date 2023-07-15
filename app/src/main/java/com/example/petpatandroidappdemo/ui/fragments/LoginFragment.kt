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
import com.example.petpatandroidappdemo.databinding.FragmentLoginBinding
import com.example.petpatandroidappdemo.models.request.LoginRequestModel
import com.example.petpatandroidappdemo.models.response.LoginResponseModel
import com.example.petpatandroidappdemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogIn.setOnClickListener {
            val phoneNumber = binding.etPhoneNumber.text.toString()
            val password = binding.etPassword.text.toString()
            userLogin(phoneNumber, password)
        }

        binding.tvRegister.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.registerFragment)

        }
    }

    private fun userLogin(phoneNumber: String, password: String) {
        RetrofitClient.getService()
            .userLogin(LoginRequestModel(phoneNumber, password))
            .enqueue(object : Callback<LoginResponseModel> {
                override fun onResponse(
                    call: Call<LoginResponseModel>,
                    response: Response<LoginResponseModel>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(context, "Successfully logged in", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(requireView())
                            .navigate(R.id.actionLoginToProductManagementNavGraph)

                    }
                }

                override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                    Log.e("TAG", "error ${t.localizedMessage}")

                }
            })


    }

}