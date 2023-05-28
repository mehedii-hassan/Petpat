package com.example.petpatandroidappdemo.ui.fragments.dialogfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.petpatandroidappdemo.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OrderDetailsDialogFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_details_dialog, container, false)
    }

}