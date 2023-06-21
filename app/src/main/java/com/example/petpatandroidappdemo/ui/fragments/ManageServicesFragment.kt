package com.example.petpatandroidappdemo.ui.fragments


import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentManageServicesBinding
import com.example.petpatandroidappdemo.adapters.MyServicesAdapter


class ManageServicesFragment : Fragment() {


    private lateinit var binding: FragmentManageServicesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentManageServicesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val servicesList = ArrayList<Int>()
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)

        val adapter = MyServicesAdapter(servicesList)
        binding.rvManageServices.layoutManager = LinearLayoutManager(view.context)
        binding.rvManageServices.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (direction == ItemTouchHelper.LEFT) {
                    // Handle left swipe (e.g., do nothing or show options)
                    Log.e("TAG", "left $direction")
                    val itemViewHolder = viewHolder as MyServicesAdapter.MyServiceViewHolder
                    //itemViewHolder.deleteButton.visibility = View.VISIBLE
                    itemViewHolder.binding.cvTrash.visibility = View.VISIBLE
                }
                // Reset the visibility of the delete button after swiping
                val itemViewHolder = viewHolder as MyServicesAdapter.MyServiceViewHolder
                itemViewHolder.binding.cvTrash.visibility = View.INVISIBLE
            }
            // Let's draw our delete view

        })
        itemTouchHelper.attachToRecyclerView(binding.rvManageServices)
    }

}
