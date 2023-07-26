package com.example.petpatandroidappdemo.ui.fragments


import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle


import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentManageServicesBinding
import com.example.petpatandroidappdemo.adapters.MyServicesAdapter
import com.example.petpatandroidappdemo.callbacks.ManageServicesItemClickListener
import com.example.petpatandroidappdemo.databinding.RvManageServicesItemDesignBinding


class ManageServicesFragment : Fragment(), ManageServicesItemClickListener {


    private lateinit var binding: FragmentManageServicesBinding
    private lateinit var servicesList: ArrayList<Int>
    private lateinit var adapter: MyServicesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentManageServicesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        servicesList = ArrayList()
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)
        servicesList.add(R.drawable.image)

        adapter = MyServicesAdapter(servicesList, this)
        binding.rvManageServices.layoutManager = LinearLayoutManager(view.context)
        binding.rvManageServices.adapter = adapter
        // binding.rvManageServices.setListener(this)

        val itemTouchHelperCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    adapter.deleteItem(position)
                }

                override fun onChildDraw(
                    c: Canvas,
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    dX: Float,
                    dY: Float,
                    actionState: Int,
                    isCurrentlyActive: Boolean
                ) {
                    if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                        val itemView = viewHolder.itemView
                        val deleteIcon = ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.trash
                        ) // Replace with your delete button icon
                        val deleteIconMargin = (itemView.height - deleteIcon!!.intrinsicHeight) / 2
                        val textMargin =
                            resources.getDimensionPixelSize(R.dimen._10dp) // Adjust the margin as per your needs

                        if (dX < 0) {
                            val deleteIconTop = itemView.top + deleteIconMargin
                            val deleteIconBottom = deleteIconTop + deleteIcon.intrinsicHeight
                            val deleteIconLeft =
                                itemView.right - deleteIconMargin - deleteIcon.intrinsicWidth
                            val deleteIconRight = itemView.right - deleteIconMargin
                            deleteIcon.let {
                                it.setBounds(
                                    deleteIconLeft,
                                    deleteIconTop,
                                    deleteIconRight,
                                    deleteIconBottom
                                )
                                it.draw(c)
                            }

                            val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
                            textPaint.textSize =
                                resources.getDimension(R.dimen._10dp) // Adjust the text size as per your needs
                            textPaint.color = ContextCompat.getColor(
                                requireContext(),
                                R.color.green
                            ) // Replace with your desired text color

                            val text = "Delete" // Replace with your desired text
                            val textX =
                                itemView.right - deleteIconMargin - deleteIcon.intrinsicWidth / 2 - textPaint.measureText(
                                    text
                                ) / 2
                            val textY = deleteIconBottom + textMargin

                            c.drawText(text, textX, textY.toFloat(), textPaint)
                        }
                    }

                    super.onChildDraw(
                        c,
                        recyclerView,
                        viewHolder,
                        dX,
                        dY,
                        actionState,
                        isCurrentlyActive
                    )
                }


            }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(binding.rvManageServices)

    }

    override fun getManageServicesItemDesignBindingInstance(
        position: Int,
        binding: RvManageServicesItemDesignBinding
    ) {
        binding.tvProfessional.setOnClickListener {
            //itemClickListener.getManageServicesAdapterPosition(position, binding)
            // Navigation.findNavController(it).navigate(R.id.blankFragment4)
        }
        binding.cvItemServices.setOnClickListener {

            // itemClickListener.getManageServicesAdapterPosition(position, binding)

            // Navigation.findNavController(it).navigate(R.id.blankFragment4)

        }
    }

    override fun getManageServicesAdapterPosition(position: Int) {
        // Navigation.findNavController(requireView()).navigate(R.id.blankFragment4)

    }


    /* @SuppressLint("NotifyDataSetChanged")
     override fun onSwipedLeft(position: Int) {
         servicesList.remove(position)
         adapter.notifyDataSetChanged()
     }

     override fun onSwipedRight(position: Int) {
         TODO("Not yet implemented")
     }*/

}

/*        SwipeableRecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mAdapter);

        rv.setListener(new SwipeLeftRightCallback.Listener() {
            @Override
            public void onSwipedLeft(int position) {
                mList.remove(position);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onSwipedRight(int position) {
                mList.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });

	/*
         * Additional attributes:
         * */
        rv.setRightBg(R.color.blue);
        rv.setRightImage(R.drawable.ic_v);
        rv.setRightText("Right Text");

        rv.setLeftBg(R.color.red);
        rv.setLeftImage(R.drawable.ic_trash);
        rv.setLeftText("Left Text");

        rv.setTextSize(62);
        rv.setTextColor(R.color.white);*/
