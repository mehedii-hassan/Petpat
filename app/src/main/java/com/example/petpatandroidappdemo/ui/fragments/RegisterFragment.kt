package com.example.petpatandroidappdemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentRegisterBinding
import com.example.petpatandroidappdemo.models.request.RegisterRequestModel
import com.example.petpatandroidappdemo.viewmodels.RegisterViewModel

class RegisterFragment : Fragment() {


    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnRegister.setOnClickListener {
            userRegister()
        }
    }

    private fun userRegister() {
        val fName = binding.etFirstName.text.toString()
        val lName = binding.etLastName.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPass = binding.etConfirmPassword.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val emailOptional = binding.etEmailOptional.text.toString()

        val registerRequestModel = RegisterRequestModel(
            fName,
            lName,
            password,
            phoneNumber,
            emailOptional,
        )

        viewModel.getRegisterResponseData(registerRequestModel)
        viewModel.getRegisterResponseModel().observe(
            viewLifecycleOwner
        ) {

            if (it.success) {
                Toast.makeText(context, "Successfully ready to otp verify", Toast.LENGTH_SHORT)
                    .show()

                val action =
                    RegisterFragmentDirections.actionRegisterToOTPFragment(registerRequestModel)

                Navigation.findNavController(requireView())
                    .navigate(action)
            }
        }
    }
}