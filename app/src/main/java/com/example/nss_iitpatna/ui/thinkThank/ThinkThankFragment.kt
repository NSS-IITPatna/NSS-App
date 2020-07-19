package com.example.nss_iitpatna.ui.thinkThank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.nss_iitpatna.R

class ThinkThankFragment : Fragment() {

    private lateinit var viewModel: ThinkThankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ThinkThankViewModel::class.java)
        return inflater.inflate(R.layout.fragment_think_thank, container, false)
    }
}