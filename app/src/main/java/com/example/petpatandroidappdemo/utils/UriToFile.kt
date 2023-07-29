package com.example.petpatandroidappdemo.utils

import android.content.Context
import android.net.Uri
import android.os.Environment
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class UriToFile(context: Context) {
    /* private val applicationContext = context.applicationContext

     @SuppressLint("Recycle")
     fun getImageBody(imageUri: Uri): File {
         val parcelFileDescriptor = applicationContext.contentResolver.openFileDescriptor(
             imageUri,
             "r",
             null
         )
         val file = File(
             applicationContext.cacheDir,
             applicationContext.contentResolver.getFileName(imageUri)
         )
         val inputStream = FileInputStream(parcelFileDescriptor?.fileDescriptor)
         val outputStream = FileOutputStream(file)
         inputStream.copyTo(outputStream)
         return file
     }


     @SuppressLint("Range")
     fun ContentResolver.getFileName(uri: Uri): String {
         var name = ""
         val cursor = query(
             uri, null, null,
             null, null
         )
         cursor?.use {
             it.moveToFirst()
             name = it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
         }
         return name
     }*/


    fun convertImageUriToMultipartPart(context: Context, imageUri: Uri): MultipartBody.Part? {
        val imageFile = getImageFileFromUri(context, imageUri)
        if (imageFile != null) {
            val requestBody = imageFile.asRequestBody("image/*".toMediaType())
            return MultipartBody.Part.createFormData("image", imageFile.name, requestBody)
        }
        return null
    }

    private fun getImageFileFromUri(context: Context, imageUri: Uri): File? {
        val inputStream = context.contentResolver.openInputStream(imageUri)
        val imageFile = createImageFile(context)
        return try {
            val outputStream = FileOutputStream(imageFile)
            inputStream?.copyTo(outputStream)
            outputStream.close()
            inputStream?.close()
            imageFile
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    private fun createImageFile(context: Context): File {
        val timeStamp = System.currentTimeMillis()
        val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("IMG_${timeStamp}_", ".jpg", storageDir)
    }


}