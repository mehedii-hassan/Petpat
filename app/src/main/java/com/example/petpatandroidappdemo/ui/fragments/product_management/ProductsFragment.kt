package com.example.petpatandroidappdemo.ui.fragments.product_management

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petpatandroidappdemo.adapters.ProductsAdapter
import com.example.petpatandroidappdemo.databinding.FragmentProductsBinding
import com.example.petpatandroidappdemo.viewmodels.ProductsViewModel

class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding
    private lateinit var viewModel: ProductsViewModel
    private lateinit var adapter: ProductsAdapter
    //private lateinit var productResponse: ProductsResponse

    // private val args: ProductsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ProductsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        /*adapter = ProductsAdapter(productResponse)
        binding.rvProducts.layoutManager = LinearLayoutManager(context)
        binding.rvProducts.adapter = adapter*/


        //val addProductsResponse = args.addProductResponse
        val id = arguments?.getInt("spId")
        if (id != null) {
            viewModel.getProductsResponse(id).observe(viewLifecycleOwner) {
                if (it.success) {
                    // productResponse = it
                    adapter = ProductsAdapter(it)
                    binding.rvProducts.layoutManager = LinearLayoutManager(context)
                    binding.rvProducts.adapter = adapter
                    Toast.makeText(context, "Success id =  $id", Toast.LENGTH_SHORT).show()

                }
            }
        }


    }
}