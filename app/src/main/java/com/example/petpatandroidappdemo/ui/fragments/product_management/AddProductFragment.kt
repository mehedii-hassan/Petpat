package com.example.petpatandroidappdemo.ui.fragments.product_management


import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toFile
import androidx.core.net.toUri
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
import com.example.petpatandroidappdemo.models.response.LoginResponseModel
import com.example.petpatandroidappdemo.ui.fragments.dialogfragments.ImageUploadOptionDialogFragment
import com.example.petpatandroidappdemo.utils.Constants
import com.example.petpatandroidappdemo.utils.UriToFile
import com.example.petpatandroidappdemo.viewmodels.AddProductViewModel
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class AddProductFragment : Fragment(), AddProductItemSelectListener, OptionDialogDismissListener,
    CrossBtnClickDeleteListener, ImageUrlCallback {

    private lateinit var binding: FragmentAddProductBinding
    private lateinit var adapter: AddProductAdapter
    private lateinit var dialogFragment: ImageUploadOptionDialogFragment
    private var position = 0

    private val imageList = ArrayList<MultipartBody.Part>()

    //private val imageList = ArrayList<String>()
    private var count = 0
    private lateinit var loginResponse: LoginResponseModel
    private lateinit var uri: RequestBody
    private lateinit var viewModel: AddProductViewModel
    private lateinit var body: MultipartBody.Part
    private lateinit var bitmapString: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(AddProductViewModel::class.java)
        binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val token = arguments?.getString("accessToken").toString()
        val spId = arguments?.getInt("spId")
        Log.e("TAG", "token $token")
        adapter = AddProductAdapter(Constants.imageList(), this)
        binding.rvAddProduct.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)

        binding.rvAddProduct.adapter = adapter

        binding.btnSave.setOnClickListener {

            val productName = binding.etProductName.text.toString()
            val productPrice = binding.etProductPrice.text.toString()

            val name = MultipartBody.Part.createFormData("name", productName)
            val price = MultipartBody.Part.createFormData("price", productPrice)

            viewModel.getAddProductResponse(
                "Bearer $token",
                name,
                price,
                imageList
            )
                .observe(viewLifecycleOwner) {
                    if (it.success) {
                        val bundle = Bundle()
                        bundle.putInt("spId", spId!!)
                        Navigation.findNavController(requireView())
                            .navigate(R.id.actionAddProductToProductsFragment, bundle)
                        Log.e(
                            "TAG",
                            "response $it size ${imageList.size} spid" + bundle.getInt("spId")
                        )
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

    override fun getImageUrl(position: Int, url: String) {

        val path = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES
        )
        val file_ = File(path, "DemoPicture.jpg")

        try {
            path.mkdirs()

        } catch (e: Exception) {
        }

        val file = Uri.fromFile(
            File(
                requireContext().cacheDir,
                requireContext().contentResolver.getType(url.toUri())!!
            )
        ).toFile()

        body = MultipartBody.Part
            .createFormData(
                name = "profile_image",
                filename = file_.name,
                body = file_.asRequestBody()
            )


        // Make sure the Pictures directory exists.
        val imageFile = File(url)
        //val uri = imageFile.asRequestBody("image/jpeg".toMediaTypeOrNull())
        //imageList.add(uri)
        //val uri = url

        // val file = UriToFile(requireContext()).getImageBody(url.toUri())
        //val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
        /*val imageFile = File(uri)
        imageFile.mkdirs()*/

        // val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
        //body = MultipartBody.Part.createFormData("image", url, requestFile)
        imageList.add(body)


        //val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), File(url))
        //body = MultipartBody.Part.createFormData("profile", file_.name, requestBody)

        //val fileOne = requireActivity().LocalStorageProvider.getFile(activity, fileUri)

    }

}

