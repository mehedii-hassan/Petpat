package com.example.petpatandroidappdemo.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentAccountsBinding
import com.example.petpatandroidappdemo.databinding.RvMyServicesItemDesignBinding
import com.example.petpatandroidappdemo.utils.SessionManager


class AccountsFragment : Fragment() {


    private lateinit var binding: FragmentAccountsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogout.setOnClickListener {

            SessionManager.clearAccessToken(requireContext())
            Navigation.findNavController(requireView()).navigate(R.id.mainActivity)

        }
    }

}