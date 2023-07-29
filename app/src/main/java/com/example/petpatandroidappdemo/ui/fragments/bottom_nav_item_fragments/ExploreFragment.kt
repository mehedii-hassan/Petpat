package com.example.petpatandroidappdemo.ui.fragments.bottom_nav_item_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentExploreBinding


class ExploreFragment : Fragment() {


    private lateinit var binding: FragmentExploreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.llContainerMangeProducts.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_exploreFragment_to_manageProductsActivity)
        }
    }


}