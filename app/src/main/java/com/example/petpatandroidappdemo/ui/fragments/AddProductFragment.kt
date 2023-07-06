package com.example.petpatandroidappdemo.ui.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petpatandroidappdemo.adapters.AddProductAdapter
import com.example.petpatandroidappdemo.callbacks.AddProductItemSelectListener
import com.example.petpatandroidappdemo.callbacks.CrossBtnClickDeleteListener
import com.example.petpatandroidappdemo.callbacks.OptionDialogDismissListener
import com.example.petpatandroidappdemo.databinding.FragmentAddProductBinding
import com.example.petpatandroidappdemo.databinding.RvAddProductItemDesignBinding
import com.example.petpatandroidappdemo.ui.fragments.dialogfragments.ImageUploadOptionDialogFragment
import com.example.petpatandroidappdemo.utils.Constants

class AddProductFragment : Fragment(), AddProductItemSelectListener, OptionDialogDismissListener,
    CrossBtnClickDeleteListener {

    private lateinit var binding: FragmentAddProductBinding
    private lateinit var adapter: AddProductAdapter
    private lateinit var dialogFragment: ImageUploadOptionDialogFragment
    private var position = 0
    //private val list = mutableListOf<Image>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        adapter = AddProductAdapter(Constants.imageList(), this)
        binding.rvAddProduct.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvAddProduct.adapter = adapter


        binding.btnSave.setOnClickListener {


            val productName = binding.etProductName.text.toString()
            val productPrice = binding.etProductPrice.text.toString()

        }
        Log.e("TAG", "p")
    }

    //get adapter position from adapter class using callback function
    override fun getAddProductItemPosition(position: Int, binding: RvAddProductItemDesignBinding) {
        dialogFragment = ImageUploadOptionDialogFragment(binding, this)
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


}