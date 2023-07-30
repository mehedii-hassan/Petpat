package com.example.petpatandroidappdemo.ui.fragments.product_management

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petpatandroidappdemo.adapters.EditProductAdapter
import com.example.petpatandroidappdemo.databinding.FragmentEditProductsBinding
import com.example.petpatandroidappdemo.models.response.EditProductResponse
import com.example.petpatandroidappdemo.utils.SessionManager
import com.example.petpatandroidappdemo.utils.UriToFile
import com.example.petpatandroidappdemo.viewmodels.DeleteProductViewModel
import com.example.petpatandroidappdemo.viewmodels.EditProductViewModel
import okhttp3.MultipartBody
import java.io.File


class EditProductsFragment : Fragment() {

    private lateinit var binding: FragmentEditProductsBinding
    private lateinit var viewModel: EditProductViewModel
    private lateinit var deleteProductViewModel: DeleteProductViewModel
    private lateinit var adapter: EditProductAdapter
    private var productId: Int = 0
    private var list = ArrayList<MultipartBody.Part>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[EditProductViewModel::class.java]
        deleteProductViewModel = ViewModelProvider(this)[DeleteProductViewModel::class.java]
        binding = FragmentEditProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        productId = arguments?.getInt("productId", 0)!!

        viewModel.getUpdateProductResponse(productId)
            .observe(viewLifecycleOwner)
            {
                if (it.success) {
                    // list = it.data.images
                    adapter = EditProductAdapter(it.data.images)

                    binding.rvEditProduct.layoutManager =
                        LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
                    binding.rvEditProduct.adapter = adapter

                    binding.etProductName.setText(it.data.name)
                    binding.etProductPrice.setText(it.data.price)


                    try {

                        for (image in it.data.images) {
                            val body = UriToFile(requireContext()).convertImageUriToMultipartPart(
                                requireContext(),
                                image.image.toUri()
                            )
                            if (body != null) {
                                list.add(body)
                            }
                        }
                    } catch (e: Exception) {
                        Log.e("TAG", "error ${e.localizedMessage}")
                    }


                }
            }

        binding.btnReset.setOnClickListener {

            Toast.makeText(context, "reset click", Toast.LENGTH_SHORT)
                .show()
            deleteProductViewModel.getDeleteProductResponse(
                "Bearer ${SessionManager.getAuthToken(requireContext())}",
                productId
            )
                .observe(viewLifecycleOwner) {

                    if (it.success) {
                        Toast.makeText(context, "Product deleted successfully", Toast.LENGTH_SHORT)
                            .show()

                    }
                }

        }

        binding.btnSave.setOnClickListener {
            Toast.makeText(context, "btn click $productId", Toast.LENGTH_SHORT).show()


            val productName = binding.etProductName.text.toString()
            val productPrice = binding.etProductPrice.text.toString()
            val name = MultipartBody.Part.createFormData("name", productName)
            val price = MultipartBody.Part.createFormData("price", productPrice)

            viewModel.getUpdateResponse(
                "Bearer ${SessionManager.getAuthToken(requireContext())}",
                productId,
                name,
                price,
                list
            ).observe(viewLifecycleOwner) {

                Log.e("TAG", "update  response ${it.data.images}")

                if (it.success) {
                    Toast.makeText(context, "Product updated successfully", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }


    }


}