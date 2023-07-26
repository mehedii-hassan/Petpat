package com.example.petpatandroidappdemo.ui.fragments.bottom_nav_item_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.petpatandroidappdemo.R


class OrdersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

        return inflater.inflate(R.layout.fragment_orders, container, false)
    }


}