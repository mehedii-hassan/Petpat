package com.example.petpatandroidappdemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentBranchDetailsBinding
import com.example.petpatandroidappdemo.databinding.RvServicesItemDesignBinding
import com.example.petpatandroidappdemo.ui.adapters.ServicesAdapter

class BranchDetailsFragment : Fragment() {

    private lateinit var binding: FragmentBranchDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialization-----------------
        binding = FragmentBranchDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val list = ArrayList<Int>()
        list.add(R.drawable.image)
        list.add(R.drawable.image)
        list.add(R.drawable.image)


        val adapter = ServicesAdapter(list)
        binding.rvServices.layoutManager = LinearLayoutManager(view.context)
        binding.rvServices.adapter = adapter


    }
}