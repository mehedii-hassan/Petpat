package com.example.petpatandroidappdemo.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petpatandroidappdemo.callbacks.AddNewServicesItemClickListener
import com.example.petpatandroidappdemo.callbacks.AddProductItemSelectListener
import com.example.petpatandroidappdemo.callbacks.CrossBtnClickDeleteListener
import com.example.petpatandroidappdemo.databinding.RvAddNewServicesItemBinding
import com.example.petpatandroidappdemo.models.response.AddNewServicesResponse

class AddNewServicesAdapter(
    private val list: List<AddNewServicesResponse.Data>,
    fragment: Fragment
) :
    RecyclerView.Adapter<AddNewServicesAdapter.AddNewServicesViewHolder>() {

    private val itemClickListener = fragment as AddNewServicesItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddNewServicesViewHolder {
        val binding = RvAddNewServicesItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AddNewServicesViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return list.size
    }


    override fun onBindViewHolder(holder: AddNewServicesViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            itemClickListener.getAddNewServicesItemPosition(position)
        }
        holder.bind(position)

    }


    inner class AddNewServicesViewHolder(val binding: RvAddNewServicesItemBinding) :
        ViewHolder(binding.root) {


        fun bind(position: Int) {

            binding.tvAddNewServicesItem.text = list[position].name

        }
    }

}