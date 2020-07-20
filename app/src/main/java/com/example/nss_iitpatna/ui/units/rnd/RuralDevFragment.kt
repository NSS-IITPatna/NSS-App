package com.example.nss_iitpatna.ui.units.rnd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.nss_iitpatna.R
import com.google.android.material.appbar.CollapsingToolbarLayout

class RuralDevFragment : Fragment() {

    companion object {
        fun newInstance() = RuralDevFragment()
    }

    private lateinit var viewModel: RuralDevViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rural_dev, container, false)

        val collapsingToolbarLayout: CollapsingToolbarLayout =
            requireActivity().findViewById(R.id.toolbar_layout)
        collapsingToolbarLayout.setBackgroundResource(R.drawable.rural_dev_appbar)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RuralDevViewModel::class.java)
        // TODO: Use the ViewModel
    }

}