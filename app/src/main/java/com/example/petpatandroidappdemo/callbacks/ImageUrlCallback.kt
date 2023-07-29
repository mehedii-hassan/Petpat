package com.example.petpatandroidappdemo.callbacks

import android.net.Uri

interface ImageUrlCallback {
    fun getImageUri(position: Int, uri: Uri?)
}