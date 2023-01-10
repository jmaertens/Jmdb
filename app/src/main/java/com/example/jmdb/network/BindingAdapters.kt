package com.example.jmdb.network

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jmdb.R

//Convert imgUrl to a URI with the https scheme
    @BindingAdapter("imageUrl")
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri = it.toUri().buildUpon().build()
            val baseUrl = "https://image.tmdb.org/t/p/original"
            Glide.with(imgView.context)
                .load(baseUrl + imgUri)
                .apply(
                    RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
                .into(imgView)
        }
    }

