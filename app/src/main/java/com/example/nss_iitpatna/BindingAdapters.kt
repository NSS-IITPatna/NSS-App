package com.example.nss_iitpatna

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

@BindingAdapter("browseUrl")
fun browseUrl(imgView: ImageView, url: String?) {
    imgView.setOnClickListener {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        if (url == "")
            intent.data = Uri.parse("https://nss.iitp.ac.in/")
        else
            intent.data = Uri.parse(url)
        it.context.startActivity(intent)
    }
}