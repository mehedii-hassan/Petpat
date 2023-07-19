package com.example.petpatandroidappdemo.ui.fragments.auth

import android.os.Bundle
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
import com.example.petpatandroidappdemo.viewmodels.LoginViewModel

class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogIn.setOnClickListener {
            userLogin()
        }

        binding.tvRegister.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.actionLoginToProductManagementNavGraph)

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

                /* val action =
                     LoginFragmentDirections.actionLoginToProductManagementNavGraph()
 */

                val bundle = Bundle()
                bundle.putString("accessToken", it.data.access_token)
                //RetrofitClient.getToken(it.data.access_token)
                Navigation.findNavController(requireView())
                    .navigate(R.id.actionLoginToProductManagementNavGraph, bundle)
            }
        }

    }

}