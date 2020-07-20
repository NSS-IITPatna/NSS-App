package com.example.nss_iitpatna.ui.units.adhyayan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nss_iitpatna.R
import com.google.android.material.appbar.CollapsingToolbarLayout

class AdhyayanFragment : Fragment() {

    companion object {
        fun newInstance() =
            AdhyayanFragment()
    }

    private lateinit var viewModel: AdhyayanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_adhyayan, container, false)

        val collapsingToolbarLayout: CollapsingToolbarLayout =
            requireActivity().findViewById(R.id.toolbar_layout)
        collapsingToolbarLayout.setBackgroundResource(R.drawable.adhyayan_appbar)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AdhyayanViewModel::class.java)
        // TODO: Use the ViewModel
    }
}