package com.example.petpatandroidappdemo.ui.fragments.product_management

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.adapters.ProductsAdapter
import com.example.petpatandroidappdemo.callbacks.ProductItemsSelectListener
import com.example.petpatandroidappdemo.databinding.FragmentProductsBinding
import com.example.petpatandroidappdemo.models.response.ProductsResponse
import com.example.petpatandroidappdemo.utils.SessionManager
import com.example.petpatandroidappdemo.viewmodels.ProductsViewModel

class ProductsFragment : Fragment(), ProductItemsSelectListener {


    private lateinit var binding: FragmentProductsBinding
    private lateinit var viewModel: ProductsViewModel
    private lateinit var adapter: ProductsAdapter
    private lateinit var productsResponse: ProductsResponse
    private var page = 1
    private var perPage = 10
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
        binding.btnAddProduct.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.addProductFragment)
        }
        viewModel.getProductsResponse(SessionManager.getSPId(requireContext()))
            .observe(viewLifecycleOwner) {
                if (it.success) {
                    productsResponse = it
                    adapter = ProductsAdapter(it.data, requireContext(), this)
                    binding.rvProducts.layoutManager = LinearLayoutManager(context)
                    binding.rvProducts.adapter = adapter
                    Log.e("TAG", "product response success ")
                }
            }
    }

    override fun getProductItemsPosition(position: Int) {
        val bundle = Bundle()
        bundle.putInt("productId", productsResponse.data[position].id)
        Navigation.findNavController(requireView())
            .navigate(R.id.actionProductsToEditProductsFragment, bundle)
    }


}