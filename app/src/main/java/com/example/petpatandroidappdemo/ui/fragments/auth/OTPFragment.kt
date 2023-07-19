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
import androidx.navigation.fragment.navArgs
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentOTPBinding
import com.example.petpatandroidappdemo.models.request.OtpRequestModel
import com.example.petpatandroidappdemo.models.request.RegisterRequestModel
import com.example.petpatandroidappdemo.viewmodels.OtpViewModel

class OTPFragment : Fragment() {


    private lateinit var binding: FragmentOTPBinding
    private lateinit var viewModel: OtpViewModel
    private lateinit var registerRequestModel: RegisterRequestModel

    // get the arguments from the Registration fragment
    private val args: OTPFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOTPBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(OtpViewModel::class.java)

        // Receive the arguments in a variable-----------------------
        registerRequestModel = args.registerRequestModel
        //registerRequestModel = OTPFragmentArgs.fromBundle(arguments).registerRequestModel
        Log.e("TAG", " ${registerRequestModel.phone}")
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
        val otpRequestModel = OtpRequestModel(false, otpString, registerRequestModel.phone)

        viewModel.getOtpResponseData(otpRequestModel)

        viewModel.getOtpResponseModel().observe(
            viewLifecycleOwner
        ) {
            if (it.success) {
                Toast.makeText(context, "Successfully Registered", Toast.LENGTH_SHORT)
                    .show()
                Navigation.findNavController(requireView()).navigate(R.id.actionOTPToLoginFragment)
            }
        }
    }
}