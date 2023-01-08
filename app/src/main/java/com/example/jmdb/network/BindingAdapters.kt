package com.example.jmdb.network

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

    //Convert imgUrl to a URI with the https scheme
    @BindingAdapter("imageUrl")
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .into(imgView)
        }
    }

