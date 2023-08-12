package com.example.petpatandroidappdemo.ui.fragments.service_management

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentServicesBinding


class ServicesFragment : Fragment(), OnClickListener {


    private lateinit var binding: FragmentServicesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServicesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnAddServices.setOnClickListener(this)
    }

    //set event with button click------------------------------------------
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnAddServices -> {
                Navigation.findNavController(v).navigate(R.id.action_servicesFragment_to_addNewServicesFragment)
            }
        }

    }
}