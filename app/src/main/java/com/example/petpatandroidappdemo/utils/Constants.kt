package com.example.petpatandroidappdemo.utils

import com.example.petpatandroidappdemo.R

object Constants {


    const val PHOTOS_API_KEY = "dYQu5f_7Vy3UjqxRlZZx7Kh7uqYQfHlkVd_CHhNFvQw"
    const val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjkyMjU1ODYyLCJpYXQiOjE2ODk2NjM4NjIsImp0aSI6IjcxY2JmYzU3ZjUxNjRiYmM4YTc1NTNkNzRkMzIwNjk1IiwidXNlcl9pZCI6MjAwfQ.bwBpUZ_gkMOKxfPSZGD-TXlBVzLn5P9adjfbAXiJKf0"
    fun imageList(): ArrayList<Int> {
        val imageList = ArrayList<Int>()
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)

        return imageList
    }

}