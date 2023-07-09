package com.example.petpatandroidappdemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.adapters.PaginationAdapter
import com.example.petpatandroidappdemo.databinding.FragmentGalleryBinding


class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding
    private lateinit var adapter: PaginationAdapter
    private lateinit var galleryImageList: ArrayList<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        galleryImageList = ArrayList()
        galleryImageList.add(R.drawable.dog_img)
        galleryImageList.add(R.drawable.dog)
        galleryImageList.add(R.drawable.dog_img)
        galleryImageList.add(R.drawable.dog)
        galleryImageList.add(R.drawable.dog_img)
        galleryImageList.add(R.drawable.dog)
        galleryImageList.add(R.drawable.dog_img)
        galleryImageList.add(R.drawable.dog)
        galleryImageList.add(R.drawable.dog_img)
        galleryImageList.add(R.drawable.dog)
        galleryImageList.add(R.drawable.dog_img)
        galleryImageList.add(R.drawable.dog)
        galleryImageList.add(R.drawable.dog_img)
        galleryImageList.add(R.drawable.dog)

/*


        adapter = GalleryAdapter()
        binding.rvGallery.layoutManager =
            GridLayoutManager(view.context, 3, GridLayoutManager.VERTICAL, false)
        binding.rvGallery.adapter = adapter
*/


    }


}