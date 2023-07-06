package com.example.petpatandroidappdemo.utils

import com.example.petpatandroidappdemo.R

object Constants {


    val PHOTOS_API_KEY = "dYQu5f_7Vy3UjqxRlZZx7Kh7uqYQfHlkVd_CHhNFvQw"

    fun imageList(): ArrayList<Int> {
        val imageList = ArrayList<Int>()
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)

        return imageList
    }

}