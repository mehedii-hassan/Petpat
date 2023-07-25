package com.example.petpatandroidappdemo.adapters

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toFile
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.RvProductsItemDesignBinding
import com.example.petpatandroidappdemo.models.response.ProductsResponse
import com.google.android.gms.fido.fido2.api.common.RequestOptions
import com.squareup.picasso.Picasso
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class ProductsAdapter(
    val productsResponse: List<ProductsResponse.Data>,
    val context: Context
) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = RvProductsItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsResponse.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ProductsViewHolder(val binding: RvProductsItemDesignBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {

            try {
                binding.tvName.text = productsResponse[position].name
                binding.tvPrice.text = productsResponse[position].price
                //binding.ivProductsItem.setImageResource(R.drawable.image)
                val uri = Uri.parse(productsResponse[position].images[position].image)

                // val fileReqBody = uri.asRequestBody("image/*".toMediaType()).toString()
                Picasso.get().load(uri)
                    .into(binding.ivProductsItem)

                Log.e("TAG", "uri adapter= $uri")
            } catch (e: Exception) {

            }

        }
    }

}