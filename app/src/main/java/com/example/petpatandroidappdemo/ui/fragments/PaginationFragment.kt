package com.example.petpatandroidappdemo.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.petpatandroidappdemo.adapters.PaginationAdapter
import com.example.petpatandroidappdemo.databinding.FragmentPaginationBinding
import com.example.petpatandroidappdemo.models.gallery.PhotoModel
import com.example.petpatandroidappdemo.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaginationFragment : Fragment() {


    private val page = 1
    private val pageSize = 30
    private val imageList = mutableListOf<PhotoModel>()
    private lateinit var adapter: PaginationAdapter
    private lateinit var binding: FragmentPaginationBinding
    private var temp = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentPaginationBinding.inflate(inflater, container, false)



        adapter = PaginationAdapter(imageList)
        binding.rvPagination.layoutManager =
            GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        binding.rvPagination.adapter = adapter

        if (temp == 0) {

            getData()
        }
        binding.rvPagination.addOnScrollListener(object : OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                //super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                temp = 1
                val visibleItemCount =
                    (binding.rvPagination.layoutManager as GridLayoutManager).childCount
                val totalItemCount =
                    (binding.rvPagination.layoutManager as GridLayoutManager).itemCount
                val firstVisibleItemPosition =
                    (binding.rvPagination.layoutManager as GridLayoutManager).findFirstVisibleItemPosition()

                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                    // Load more data
                    getData()
                }
            }
        })

        return binding.root
    }

    fun getData() {

        ApiClient.getService().getImages(page, 10).enqueue(object : Callback<List<PhotoModel>> {
            override fun onResponse(
                call: Call<List<PhotoModel>>,
                response: Response<List<PhotoModel>>
            ) {

                if (response.body() != null) {
                    imageList.addAll(response.body()!!)
                    adapter.submitNewImageList(imageList)
                }
                Log.e("TAG", "size= ${imageList.size}")
                Toast.makeText(context, "" + imageList.size, Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
                Log.e("TAG", "failed ${t.localizedMessage}")
            }
        })

    }

}