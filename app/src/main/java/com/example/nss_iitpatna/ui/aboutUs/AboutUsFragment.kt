package com.example.nss_iitpatna.ui.aboutUs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.nss_iitpatna.R

class AboutUsFragment : Fragment() {

    private lateinit var viewModel: AboutUsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AboutUsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }
}