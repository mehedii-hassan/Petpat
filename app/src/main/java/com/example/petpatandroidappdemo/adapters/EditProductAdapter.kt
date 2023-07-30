package com.example.petpatandroidappdemo.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.databinding.RvEditProductItemDesignBinding
import com.example.petpatandroidappdemo.databinding.RvProductsItemDesignBinding
import com.example.petpatandroidappdemo.models.response.EditProductResponse
import com.squareup.picasso.Picasso

class EditProductAdapter(
    private val imageList: List<EditProductResponse.Image>
) : RecyclerView.Adapter<EditProductAdapter.EditProductViewHolder>() {


    override

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditProductViewHolder {
        val binding = RvEditProductItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return EditProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: EditProductViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class EditProductViewHolder(val binding: RvEditProductItemDesignBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {


            try {

                if (imageList[position].image.isNotEmpty()) {
                    binding.clUploadContainer.visibility = View.VISIBLE
                    binding.cvUploadContainer.visibility = View.GONE
                    Picasso.get().load(imageList[position].image)
                        .into(binding.ivUploadOne)
                    Log.e("TAG", "new image uri ${imageList[position].image}")
                } else {
                    binding.clUploadContainer.visibility = View.GONE
                    binding.cvUploadContainer.visibility = View.VISIBLE
                }

            } catch (e: Exception) {

                Log.e("TAG", " ${e.localizedMessage}")
            }

        }
    }

}