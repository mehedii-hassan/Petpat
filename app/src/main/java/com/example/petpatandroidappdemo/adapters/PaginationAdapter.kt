package com.example.petpatandroidappdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.databinding.RvGalleryItemDesignBinding
import com.example.petpatandroidappdemo.models.gallery.PhotoModel
import com.squareup.picasso.Picasso

class PaginationAdapter(private var list: List<PhotoModel>) :
    RecyclerView.Adapter<PaginationAdapter.PaginationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaginationViewHolder {
        val binding = RvGalleryItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PaginationViewHolder(binding)
    }

    fun submitNewImageList(imageList: List<PhotoModel>) {
        this.list = imageList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: PaginationViewHolder, position: Int) {

        holder.bind(position)

    }


    inner class PaginationViewHolder(val binding: RvGalleryItemDesignBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {
            // binding.ivGalleryItem.setImageURI(list[position].urls.regular.toString())
            Picasso.get().load(list[position].urls.regular).into(binding.ivGalleryItem)

        }

    }

}