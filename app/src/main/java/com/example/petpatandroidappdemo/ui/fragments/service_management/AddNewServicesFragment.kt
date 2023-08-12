package com.example.petpatandroidappdemo.ui.fragments.service_management

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.adapters.AddNewServicesAdapter
import com.example.petpatandroidappdemo.callbacks.AddNewServicesItemClickListener
import com.example.petpatandroidappdemo.databinding.FragmentAddNewServicesBinding
import com.example.petpatandroidappdemo.viewmodels.AddNewServicesViewModel

class AddNewServicesFragment : Fragment(), AddNewServicesItemClickListener {


    private lateinit var viewModel: AddNewServicesViewModel
    private lateinit var binding: FragmentAddNewServicesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[AddNewServicesViewModel::class.java]
        binding = FragmentAddNewServicesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAddNewServicesResponse().observe(viewLifecycleOwner) {

            if (it.success) {
                val adapter = AddNewServicesAdapter(it.data, this)
                binding.rvMyServices.layoutManager = LinearLayoutManager(context)
                binding.rvMyServices.adapter = adapter
            }
        }
    }

    override fun getAddNewServicesItemPosition(position: Int) {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_addNewServicesFragment_to_createNewServicesFragment)
    }

}