package com.example.petpatandroidappdemo.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initialization-------------------
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bottomNavigationId.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mi_home -> {
                    Navigation.findNavController(binding.fragmentContainerView2)
                        .navigate(R.id.exploreFragment)
                    true
                }

                R.id.mi_orders -> {
                    Navigation.findNavController(binding.fragmentContainerView2)
                        .navigate(R.id.ordersFragment)
                    true
                }

                R.id.mi_notification -> {
                    Navigation.findNavController(binding.fragmentContainerView2)
                        .navigate(R.id.notificationsFragment)
                    true
                }

                R.id.mi_accounts -> {
                    Navigation.findNavController(binding.fragmentContainerView2)
                        .navigate(R.id.accountsFragment)
                    true
                }

                else -> {
                    false
                }
            }


        }
    }


}