package com.example.petpatandroidappdemo.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.llContainerMangeProducts.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.actionHomeToManageProductsActivity)
            requireActivity().finish()
        }
        binding.llContainerMangeServices.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.actionHomeToManageServicesActivity)
            requireActivity().finish()
        }
    }


}