package com.example.petpatandroidappdemo.ui.fragments.addproducts


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petpatandroidappdemo.adapters.AddProductAdapter
import com.example.petpatandroidappdemo.callbacks.AddProductItemSelectListener
import com.example.petpatandroidappdemo.callbacks.CrossBtnClickDeleteListener
import com.example.petpatandroidappdemo.callbacks.ImageUrlCallback
import com.example.petpatandroidappdemo.callbacks.OptionDialogDismissListener
import com.example.petpatandroidappdemo.databinding.FragmentAddProductBinding
import com.example.petpatandroidappdemo.databinding.RvAddProductItemDesignBinding
import com.example.petpatandroidappdemo.models.response.AddProductResponseModel
import com.example.petpatandroidappdemo.models.response.LoginResponseModel
import com.example.petpatandroidappdemo.network.RetrofitClient
import com.example.petpatandroidappdemo.ui.fragments.dialogfragments.ImageUploadOptionDialogFragment
import com.example.petpatandroidappdemo.utils.Constants
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class AddProductFragment : Fragment(), AddProductItemSelectListener, OptionDialogDismissListener,
    CrossBtnClickDeleteListener, ImageUrlCallback {

    private lateinit var binding: FragmentAddProductBinding
    private lateinit var adapter: AddProductAdapter
    private lateinit var dialogFragment: ImageUploadOptionDialogFragment
    private var position = 0
    private val imageList = ArrayList<RequestBody>()
    private var count = 0
    private lateinit var loginResponse: LoginResponseModel
    private lateinit var uri: RequestBody

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val token = arguments?.getString("accessToken").toString()
        Log.e("TAG", "token $token")
        adapter = AddProductAdapter(Constants.imageList(), this)
        binding.rvAddProduct.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)

        binding.rvAddProduct.adapter = adapter

        binding.btnSave.setOnClickListener {

            val productName = binding.etProductName.text.toString()
            val productPrice = binding.etProductPrice.text.toString()


            RetrofitClient.getService()

                .addProductForListOfImage("Bearer $token", productName, productPrice, imageList)
                .enqueue(object : Callback<AddProductResponseModel> {
                    override fun onResponse(
                        call: Call<AddProductResponseModel>,
                        response: Response<AddProductResponseModel>
                    ) {
                        Log.e(
                            "TAG",
                            "response ${response.body()} size ${imageList.size}"
                        )
                        // Toast.makeText(requireContext(), "size = ${response.body()?.data?.images?.size}").show()
                    }

                    override fun onFailure(call: Call<AddProductResponseModel>, t: Throwable) {
                        Log.e("TAG", "error ${t.localizedMessage}")
                    }
                })
        }
        Log.e("TAG", "p")
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

    override fun getImageUrl(position: Int, url: String) {
        count++
        val imageFile = File(url)
        val uri = imageFile.asRequestBody("image/jpeg".toMediaType())
        imageList.add(uri)
    }

}