package com.example.petpatandroidappdemo.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.petpatandroidappdemo.R
import com.example.petpatandroidappdemo.databinding.FragmentWebViewBinding


class WebViewFragment : Fragment() {


    private lateinit var binding: FragmentWebViewBinding


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebViewBinding.inflate(inflater, container, false)

        val url =
            "https://secure.paytabs.sa/payment/page/5E56DA3682E4184DD655C5FB8320BE15D41E68ED79C21C189FE6D52E" // Replace with your desired URL
        binding.webView.loadUrl(url)
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()
        return binding.root
    }


}