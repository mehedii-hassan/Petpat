package com.example.petpatandroidappdemo.ui.fragments.dialogfragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.callbacks.AddProductItemSelectListener
import com.example.petpatandroidappdemo.callbacks.OptionDialogDismissListener
import com.example.petpatandroidappdemo.databinding.FragmentUploadOptionDialogBinding
import com.example.petpatandroidappdemo.databinding.RvAddProductItemDesignBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class UploadOptionDialogFragment(
    private val binding_: RvAddProductItemDesignBinding,
    fragment: Fragment
) :
    BottomSheetDialogFragment() {

    private val dialogDismissListener = fragment as OptionDialogDismissListener

    private lateinit var binding: FragmentUploadOptionDialogBinding
    private val PICK_IMAGE_REQUEST = 1
    private val REQUEST_IMAGE_CAPTURE = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUploadOptionDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvViewPhotoLibrary.setOnClickListener {
            openGallery()
        }
        binding.tvTakePhoto.setOnClickListener {
            openCamera()
        }

    }

    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(requireContext().packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }


    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            binding_.ivUploadOne.setImageURI(selectedImageUri)
            binding_.cvUploadContainer.visibility = View.GONE
            binding_.clUploadContainer.visibility = View.VISIBLE
            dialogDismissListener.dismissOptiondialog()
        }

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding_.ivUploadOne.setImageBitmap(imageBitmap)
            binding_.cvUploadContainer.visibility = View.GONE
            binding_.clUploadContainer.visibility = View.VISIBLE
            dialogDismissListener.dismissOptiondialog()
        }
    }


}