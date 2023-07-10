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
import com.example.petpatandroidappdemo.models.unsplashapimodel.PhotoModel
import com.example.petpatandroidappdemo.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaginationFragment : Fragment() {


    private var page = 1
    private var perPage = 10
    private val imageList = mutableListOf<PhotoModel>()
    private lateinit var adapter: PaginationAdapter
    private lateinit var binding: FragmentPaginationBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private var temp = 0
    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentPaginationBinding.inflate(inflater, container, false)
        gridLayoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)


        binding.progressBarId.visibility = View.VISIBLE


        adapter = PaginationAdapter(imageList)
        binding.rvPagination.layoutManager = gridLayoutManager
        binding.rvPagination.adapter = adapter

        if (temp == 0) {

            Log.e("TAG", "before Count")
            getData(page, perPage)
        }
        binding.rvPagination.addOnScrollListener(object : OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                //super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount = gridLayoutManager.childCount
                val totalItemCount = gridLayoutManager.itemCount
                val firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition()

                Log.e(
                    "TAG",
                    "vItem =${visibleItemCount} tItem =${totalItemCount} fPosition =${firstVisibleItemPosition} "
                )

                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                    // Load more data
                    binding.progressBarId.visibility = View.VISIBLE
                    count++
                    page++
                    getData(page, perPage)
                    Log.e("TAG", "Count =${count}")
                }
            }
        })

        return binding.root
    }

    fun getData(page: Int, perPage: Int) {

        ApiClient.getService().getImages(page, perPage)
            .enqueue(object : Callback<List<PhotoModel>> {
                override fun onResponse(
                    call: Call<List<PhotoModel>>,
                    response: Response<List<PhotoModel>>
                ) {

                    binding.progressBarId.visibility = View.VISIBLE


                    if (response.body() != null) {
                        imageList.addAll(response.body()!!)
                        adapter.submitNewImageList(imageList)
                        binding.progressBarId.visibility = View.GONE

                    }
                    Log.e("TAG", "size= ${imageList.size} count =${count}")
                    Toast.makeText(context, "" + imageList.size, Toast.LENGTH_LONG).show()

                }

                override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
                    Log.e("TAG", "failed ${t.localizedMessage}")
                }
            })

    }

}