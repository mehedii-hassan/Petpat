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
import com.example.petpatandroidappdemo.databinding.FragmentCarDetailsBinding
import com.example.petpatandroidappdemo.ui.adapters.ProductsAdapter
import com.example.petpatandroidappdemo.ui.adapters.ReviewAndRatingAdapter
import com.example.petpatandroidappdemo.ui.adapters.ServicesAdapter

class CarDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCarDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialization-----------------
        binding = FragmentCarDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val servicesList = ArrayList<Int>()
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)

        val productsList = ArrayList<Int>()
        productsList.add(R.drawable.image_product)
        productsList.add(R.drawable.image_product)
        productsList.add(R.drawable.image_product)

        val profileList = ArrayList<Int>()
        profileList.add(R.drawable.profile)
        profileList.add(R.drawable.profile)
        profileList.add(R.drawable.profile)


        val servicesAdapter = ServicesAdapter(servicesList)
        binding.rvServices.layoutManager = LinearLayoutManager(view.context)
        binding.rvServices.adapter = servicesAdapter

        val productsAdapter = ProductsAdapter(productsList)
        binding.rvProducts.layoutManager = LinearLayoutManager(view.context)
        binding.rvProducts.adapter = productsAdapter

        val reviewAdapter = ReviewAndRatingAdapter(profileList)
        binding.rvUserReview.layoutManager = LinearLayoutManager(view.context)
        binding.rvUserReview.adapter = reviewAdapter


        //imageSlider----------------------
        val sliderList = ArrayList<SlideModel>() // Create image list


        sliderList.add(SlideModel(R.drawable.slider_img, ScaleTypes.FIT))
        sliderList.add(SlideModel(R.drawable.slider_img, ScaleTypes.FIT))
        sliderList.add(SlideModel(R.drawable.slider_img, ScaleTypes.FIT))
        sliderList.add(SlideModel(R.drawable.slider_img, ScaleTypes.FIT))
        binding.imageSlider.setImageList(sliderList, ScaleTypes.FIT)


    }

}