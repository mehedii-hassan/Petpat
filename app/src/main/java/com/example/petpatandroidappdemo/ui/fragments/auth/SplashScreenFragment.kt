package com.example.petpatandroidappdemo.ui.fragments.auth

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentSplashScreenBinding
import com.example.petpatandroidappdemo.utils.SessionManager


@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {


    private lateinit var binding: FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)

        //Get data from SharedPreferences--------------------------------
        //accessToken = SessionManager.getAuthToken(requireContext()).toString()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        Handler().postDelayed({
            if (SessionManager.isLoggedIn(requireContext())) {
                Navigation.findNavController(requireView())
                    .navigate(R.id.actionSplashToHomeActivity)
                requireActivity().finish()
            } else {

                Navigation.findNavController(requireView())
                    .navigate(R.id.actionSplashToLoginFragment)
            }

        }, 3000)
    }

}