package com.example.petpatandroidappdemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentBranchDetailsBinding
import com.example.petpatandroidappdemo.databinding.FragmentServiceDetailsBinding
import com.example.petpatandroidappdemo.ui.adapters.BeautyServiceAdapter
import com.example.petpatandroidappdemo.ui.adapters.ServicesAdapter


class ServiceDetailsFragment : Fragment() {

    private lateinit var binding: FragmentServiceDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialization-----------------
        binding = FragmentServiceDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //imageSlider----------------------
        val sliderList = ArrayList<SlideModel>() // Create image list


        sliderList.add(SlideModel(R.drawable.slider_img, ScaleTypes.FIT))
        sliderList.add(SlideModel(R.drawable.slider_img, ScaleTypes.FIT))
        sliderList.add(SlideModel(R.drawable.slider_img, ScaleTypes.FIT))
        sliderList.add(SlideModel(R.drawable.slider_img, ScaleTypes.FIT))
        binding.imageSlider.setImageList(sliderList, ScaleTypes.FIT)

        val beautiServiceList = ArrayList<String>()
        beautiServiceList.add("Braids")
        beautiServiceList.add("Braids")
        beautiServiceList.add("Braids")
        beautiServiceList.add("Braids")
        beautiServiceList.add("Braids")
        beautiServiceList.add("Braids")

        val beautiServicesAdapter = BeautyServiceAdapter(beautiServiceList)
        binding.rvBeautyService.layoutManager = LinearLayoutManager(view.context)
        binding.rvBeautyService.adapter = beautiServicesAdapter


    }

}