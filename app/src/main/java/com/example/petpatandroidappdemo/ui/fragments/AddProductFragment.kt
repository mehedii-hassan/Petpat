package com.example.petpatandroidappdemo.ui.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.adapters.AddProductAdapter
import com.example.petpatandroidappdemo.callbacks.AddProductItemSelectListener
import com.example.petpatandroidappdemo.databinding.FragmentAddProductBinding
import com.example.petpatandroidappdemo.databinding.RvAddProductItemDesignBinding

class AddProductFragment : Fragment(), AddProductItemSelectListener {

    private lateinit var binding: FragmentAddProductBinding
    private lateinit var bindingOne: RvAddProductItemDesignBinding
    private lateinit var adapter: AddProductAdapter
    private lateinit var imageList: ArrayList<Int>

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddProductBinding.inflate(inflater, container, false)
       // bindingOne = RvAddProductItemDesignBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        imageList = ArrayList()
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)
        imageList.add(R.drawable.arrow_upload)


        adapter = AddProductAdapter(imageList, this)
        binding.rvAddProduct.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvAddProduct.adapter = adapter
    }

    //get adapter position from adapter class using callback function
    override fun getAddProductItemPosition(position: Int, binding: RvAddProductItemDesignBinding) {
        Toast.makeText(context, "position : $position", Toast.LENGTH_SHORT).show()
        openGallery()
        Log.e("TAG", "pos$position")
        bindingOne = binding
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
        // Navigation.findNavController(binding.root).navigate()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            Log.e("TAG", "before")
            // Do something with the selected image URI (e.g., display it in an ImageView)
            bindingOne.ivUploadOne.setImageURI(selectedImageUri)
            bindingOne.cvUploadContainer.visibility = View.GONE
            bindingOne.clUploadContainer.visibility = View.VISIBLE
            Log.e("TAG", "after")

        }
    }

}