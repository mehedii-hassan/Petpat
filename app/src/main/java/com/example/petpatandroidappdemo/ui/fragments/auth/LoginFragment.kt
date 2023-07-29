package com.example.petpatandroidappdemo.ui.fragments.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentLoginBinding
import com.example.petpatandroidappdemo.models.request.LoginRequestModel
import com.example.petpatandroidappdemo.utils.SessionManager
import com.example.petpatandroidappdemo.viewmodels.LoginViewModel

class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var accessToken: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]


        //Get data from SharedPreferences--------------------------------
        accessToken = SessionManager.getAuthToken(requireContext()).toString()

        Log.e("TAG", "access_token = $accessToken ")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //if token is not null then navigate to
        if (accessToken.isNotEmpty()) {
            Navigation.findNavController(requireView()).navigate(R.id.actionLoginToHomeActivity)
            Log.e("TAG", "access_token= $accessToken ")
            return
        }
        binding.btnLogIn.setOnClickListener {
            userLogin()
        }


        binding.tvRegister.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.loginFragment)

        }
    }

    private fun userLogin() {
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val password = binding.etPassword.text.toString()

        val loginRequest = LoginRequestModel(phoneNumber, password)

        viewModel.getLoginResponseData(loginRequest)
        viewModel.getLoginResponseModel().observe(viewLifecycleOwner) {
            if (it.success) {
                Toast.makeText(context, "Login successfully", Toast.LENGTH_SHORT)
                    .show()

                //Save access token and sp id  to SharedPreferences-----------------------
                SessionManager.saveAuthToken(requireContext(), it.data.access_token)
                SessionManager.saveSPId(requireContext(), it.data.service_provider_id)

                //RetrofitClient.getToken(it.data.access_token)
                Navigation.findNavController(requireView())
                    .navigate(R.id.actionLoginToHomeActivity)


            }
        }

    }

}