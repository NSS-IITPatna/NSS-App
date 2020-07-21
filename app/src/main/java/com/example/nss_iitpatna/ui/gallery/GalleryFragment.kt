package com.example.nss_iitpatna.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
import com.example.nss_iitpatna.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentGalleryBinding.inflate(inflater)
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        binding.galleryViewModel = galleryViewModel
        binding.lifecycleOwner = this

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, 1)
        staggeredGridLayoutManager.gapStrategy = GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        binding.galleryRecyclerView.layoutManager = staggeredGridLayoutManager

        val galleryAdapter = GalleryAdapter()
        binding.galleryRecyclerView.adapter = galleryAdapter

        galleryViewModel.images.observe(viewLifecycleOwner, Observer {
            galleryAdapter.submitList(it)
        })

        return binding.root
    }
}