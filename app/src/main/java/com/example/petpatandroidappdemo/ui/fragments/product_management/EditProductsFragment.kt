package com.example.petpatandroidappdemo.ui.fragments.product_management

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petpatandroidappdemo.adapters.EditProductAdapter
import com.example.petpatandroidappdemo.databinding.FragmentEditProductsBinding
import com.example.petpatandroidappdemo.viewmodels.EditProductViewModel


class EditProductsFragment : Fragment() {

    private lateinit var binding: FragmentEditProductsBinding
    private lateinit var viewModel: EditProductViewModel
    private lateinit var adapter: EditProductAdapter
    private var productId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[EditProductViewModel::class.java]
        binding = FragmentEditProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        productId = arguments?.getInt("productId", 0)!!

        viewModel.getUpdateProductResponse(productId)
            .observe(viewLifecycleOwner)
            {
                if (it.success) {
                    adapter = EditProductAdapter(it.data.images)

                    binding.rvEditProduct.layoutManager =
                        LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
                    binding.rvEditProduct.adapter = adapter

                    binding.etProductName.setText(it.data.name)
                    binding.etProductPrice.setText(it.data.price)

                }
            }

    }


}