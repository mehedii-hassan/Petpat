package com.example.petpatandroidappdemo.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.core.widget.NestedScrollView.OnScrollChangeListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.petpatandroidappdemo.adapters.PaginationAdapter
import com.example.petpatandroidappdemo.databinding.FragmentPaginationBinding
import com.example.petpatandroidappdemo.databinding.FragmentPaginationTwoBinding
import com.example.petpatandroidappdemo.models.unsplashapimodel.PhotoModel
import com.example.petpatandroidappdemo.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaginationFragmentTwo : Fragment() {


    private var page = 1
    private var perPage = 10
    private val imageList = mutableListOf<PhotoModel>()
    private lateinit var adapter: PaginationAdapter
    private lateinit var binding: FragmentPaginationTwoBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentPaginationTwoBinding.inflate(inflater, container, false)
        gridLayoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)


        binding.progressBarTwo.visibility = View.VISIBLE

        getData(page, perPage)


        adapter = PaginationAdapter(imageList)
        binding.rvPaginationTwo.layoutManager = gridLayoutManager
        binding.rvPaginationTwo.adapter = adapter


        binding.nestedScrollViewId.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            // on scroll change we are checking when users scroll as bottom.
            if (scrollY == binding.nestedScrollViewId.getChildAt(0).measuredHeight - binding.nestedScrollViewId.getMeasuredHeight()) {
                // in this method we are incrementing page number,
                // making progress bar visible and calling get data method.
                page++
                binding.progressBarTwo.visibility = View.VISIBLE
                getData(page, perPage)
            }
        }

        return binding.root
    }

    fun getData(page: Int, perPage: Int) {

        ApiClient.getService().getImages(page, perPage)
            .enqueue(object : Callback<List<PhotoModel>> {
                override fun onResponse(
                    call: Call<List<PhotoModel>>,
                    response: Response<List<PhotoModel>>
                ) {

                    binding.progressBarTwo.visibility = View.VISIBLE
                    if (response.body() != null) {
                        imageList.addAll(response.body()!!)
                        adapter.submitNewImageList(imageList)
                        binding.progressBarTwo.visibility = View.GONE

                    }
                    Log.e("TAG", "size= ${imageList.size} count =${count}")
                    //Toast.makeText(context, "" + imageList.size, Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
                    Log.e("TAG", "failed ${t.localizedMessage}")
                }
            })

    }

}