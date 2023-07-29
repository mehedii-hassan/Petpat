package com.example.petpatandroidappdemo.adapters

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.callbacks.ProductItemsSelectListener
import com.example.petpatandroidappdemo.databinding.RvProductsItemDesignBinding
import com.example.petpatandroidappdemo.models.response.ProductsResponse
import com.squareup.picasso.Picasso

class ProductsAdapter(
    val productsResponse: List<ProductsResponse.Data>,
    val context: Context,
    fragment: Fragment
) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {
    private val productItemsClickListener = fragment as ProductItemsSelectListener


    override

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = RvProductsItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsResponse.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener {
            productItemsClickListener.getProductItemsPosition(position)

        }

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