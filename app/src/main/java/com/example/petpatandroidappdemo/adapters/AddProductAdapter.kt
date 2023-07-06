package com.example.petpatandroidappdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.callbacks.AddProductItemSelectListener
import com.example.petpatandroidappdemo.callbacks.CrossBtnClickDeleteListener
import com.example.petpatandroidappdemo.databinding.RvAddProductItemDesignBinding

class AddProductAdapter(private val list: ArrayList<Int>, fragment: Fragment) :
    RecyclerView.Adapter<AddProductAdapter.AddProductViewHolder>() {
    private val itemClickListener = fragment as AddProductItemSelectListener
    private val crossBtnClickDeleteListener = fragment as CrossBtnClickDeleteListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddProductViewHolder {
        val binding = RvAddProductItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AddProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: AddProductViewHolder, position: Int) {

        holder.bind(position)

    }


    inner class AddProductViewHolder(val binding: RvAddProductItemDesignBinding) :
        ViewHolder(binding.root) {


        fun bind(position: Int) {

            binding.ivUpload.setOnClickListener {
                itemClickListener.getAddProductItemPosition(position, binding)
            }
            binding.ivDelete.setOnClickListener {
                crossBtnClickDeleteListener.onCrossBtnClickDeleteListener(binding)
            }

        }
    }

}