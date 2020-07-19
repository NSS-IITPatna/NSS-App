package com.example.nss_iitpatna.ui.units.chetna

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.nss_iitpatna.R
import com.google.android.material.appbar.CollapsingToolbarLayout

class ChetnaFragment : Fragment() {

    companion object {
        fun newInstance() =
            ChetnaFragment()
    }

    private lateinit var viewModel: ChetnaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chetna, container, false)

        val collapsingToolbarLayout: CollapsingToolbarLayout =
            requireActivity().findViewById(R.id.toolbar_layout)
        collapsingToolbarLayout.setBackgroundResource(R.drawable.chetna_appbar)

        return view    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChetnaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}