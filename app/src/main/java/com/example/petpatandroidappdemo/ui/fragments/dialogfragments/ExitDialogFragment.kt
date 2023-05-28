package com.example.petpatandroidappdemo.ui.fragments.dialogfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.petpatandroidappdemo.databinding.FragmentExitDialogBinding


class ExitDialogFragment : DialogFragment() {


    private lateinit var binding: FragmentExitDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // initialization
        binding = FragmentExitDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogout.setOnClickListener {

            Toast.makeText(context, "Logout button clicked", Toast.LENGTH_SHORT).show()
        }
        binding.btnCancel.setOnClickListener {
            dismiss()


        }
    }


    override fun onStart() {
        super.onStart()

        val d = dialog
        if (d != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            d.window?.setLayout(width, height)
        }
    }
}