package com.example.petpatandroidappdemo.ui.fragments.service_management

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentCreateNewServicesBinding

class CreateNewServicesFragment : Fragment() {

    private var editTextCount = 0
    private lateinit var binding: FragmentCreateNewServicesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNewServicesBinding.inflate(inflater, container, false)
        // return inflater.inflate(R.layout.fragment_create_new_services, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    private fun addEditText() {
        val editText = EditText(context)
        editText.hint = "select sub services ${editTextCount + 1}"
        editText.setBackgroundResource(R.drawable.custom_button_design)

        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        editText.layoutParams = layoutParams

        binding.container.addView(editText)

        editTextCount++
    }

}