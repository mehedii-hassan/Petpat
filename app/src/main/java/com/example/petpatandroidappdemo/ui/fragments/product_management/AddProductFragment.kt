package com.example.petpatandroidappdemo.ui.fragments.product_management


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.adapters.AddProductAdapter
import com.example.petpatandroidappdemo.callbacks.AddProductItemSelectListener
import com.example.petpatandroidappdemo.callbacks.CrossBtnClickDeleteListener
import com.example.petpatandroidappdemo.callbacks.ImageUrlCallback
import com.example.petpatandroidappdemo.callbacks.OptionDialogDismissListener
import com.example.petpatandroidappdemo.databinding.FragmentAddProductBinding
import com.example.petpatandroidappdemo.databinding.RvAddProductItemDesignBinding
import com.example.petpatandroidappdemo.ui.fragments.dialogfragments.ImageUploadOptionDialogFragment
import com.example.petpatandroidappdemo.utils.Constants
import com.example.petpatandroidappdemo.utils.SessionManager
import com.example.petpatandroidappdemo.utils.UriToFile
import com.example.petpatandroidappdemo.viewmodels.AddProductViewModel
import okhttp3.MultipartBody

class AddProductFragment : Fragment(), AddProductItemSelectListener, OptionDialogDismissListener,
    CrossBtnClickDeleteListener, ImageUrlCallback {

    private lateinit var binding: FragmentAddProductBinding
    private lateinit var adapter: AddProductAdapter
    private lateinit var dialogFragment: ImageUploadOptionDialogFragment
    private var position = 0
    private val imageList = ArrayList<MultipartBody.Part>()
    private lateinit var viewModel: AddProductViewModel
    private lateinit var body: MultipartBody.Part

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[AddProductViewModel::class.java]
        binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = AddProductAdapter(Constants.imageList(), this)
        binding.rvAddProduct.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)

        binding.rvAddProduct.adapter = adapter

        binding.ivLeftArrow.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.actionAddProductFragmentTohomeActivity)
            requireActivity().finish()
        }

        binding.btnSave.setOnClickListener {

            val productName = binding.etProductName.text.toString()
            val productPrice = binding.etProductPrice.text.toString()


            val name = MultipartBody.Part.createFormData("name", productName)
            val price = MultipartBody.Part.createFormData("price", productPrice)

            viewModel.getAddProductResponse(
                "Bearer ${SessionManager.getAuthToken(requireContext())}",
                name,
                price,
                imageList
            )
                .observe(viewLifecycleOwner) {
                    if (it.success) {
                        Navigation.findNavController(requireView())
                            .navigate(R.id.actionAddProductToProductsFragment)

                    }
                }
        }
    }

    //get adapter position from adapter class using callback function
    override fun getAddProductItemPosition(position: Int, binding: RvAddProductItemDesignBinding) {
        dialogFragment = ImageUploadOptionDialogFragment(position, binding, this)
        dialogFragment.show(parentFragmentManager, "CustomDialogFragment")
        this.position = position
    }

    override fun dismissOptiondialog() {
        dialogFragment.dismiss()
    }

    override fun onCrossBtnClickDeleteListener(binding: RvAddProductItemDesignBinding) {
        binding.ivUploadOne.setImageResource(0)
        binding.cvUploadContainer.visibility = View.VISIBLE
        binding.clUploadContainer.visibility = View.GONE
    }

    override fun getImageUri(position: Int, uri: Uri?) {

        val body = UriToFile(requireContext()).convertImageUriToMultipartPart(
            requireContext(),
            uri!!
        )
        if (body != null) {
            imageList.add(body)
        }
    }

}

