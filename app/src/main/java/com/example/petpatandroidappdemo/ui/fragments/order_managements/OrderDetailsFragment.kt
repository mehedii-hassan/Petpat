package com.example.petpatandroidappdemo.ui.fragments.order_managements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentOrderDetailsBinding


class OrderDetailsFragment : Fragment() {

    private var count = 0

    private lateinit var binding: FragmentOrderDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrderDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnAccept.setOnClickListener {
            count++
            setOnButtonClickAction(count)
        }

        binding.btnDecline.setOnClickListener {
            binding.btnDecline.visibility = View.GONE
        }

        binding.btnAcceptOne.setOnClickListener {
            binding.btnAcceptOne.visibility = View.GONE
        }
        binding.btnAcceptTwo.setOnClickListener {
            binding.btnAcceptTwo.visibility = View.GONE
        }
        binding.btnAcceptThree.setOnClickListener {
            binding.btnAcceptThree.visibility = View.GONE
        }
    }

    private fun setOnButtonClickAction(count: Int) {
        when (count) {
            1 -> {
                binding.btnAccept.text = "Start processing the order"
            }

            2 -> {
                binding.btnAccept.text = "Mark as complete"
            }

            3 -> {
                binding.btnAccept.visibility = View.GONE
            }

            else -> {
                //nothing to do---------
            }
        }

    }

}