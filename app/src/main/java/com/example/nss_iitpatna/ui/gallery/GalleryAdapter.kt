package com.example.nss_iitpatna.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nss_iitpatna.databinding.CardGalleryBinding
import com.example.nss_iitpatna.network.Gallery

class GalleryAdapter() : ListAdapter<Gallery, GalleryAdapter.GalleryViewHolder>(DiffCallback) {

    class GalleryViewHolder(private val binding: CardGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gallery: Gallery) {
            binding.gallery = gallery
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GalleryViewHolder {
        return GalleryViewHolder(CardGalleryBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val gallery = getItem(position)
        holder.bind(gallery)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Gallery>() {
        override fun areItemsTheSame(oldItem: Gallery, newItem: Gallery): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Gallery, newItem: Gallery): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }
    }
}
