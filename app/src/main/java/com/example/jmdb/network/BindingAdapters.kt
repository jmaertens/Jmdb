package com.example.jmdb.network

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jmdb.R
import com.example.jmdb.screens.overviewmovies.MoviesApiStatus
import com.example.jmdb.screens.overviewmovies.PosterGridAdapter


//Convert imgUrl to a URI and load it into the imageView
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

//Add a binding adapter for the listData attribute that calls submitList on the RV adapter
//Initialize the photogridadapter with listdata, observe the livedata
    @BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
        val adapter = recyclerView.adapter as PosterGridAdapter
        adapter.submitList(data)
    }

//Add the binding adapter to show the MoviesApi status in the ImageView and show/hide the view
    @BindingAdapter("moviesApiStatus")
    fun bindStatus(statusImageView: ImageView, status: MoviesApiStatus?) {
        when (status) {
            MoviesApiStatus.LOADING -> {
                statusImageView.visibility = ImageView.VISIBLE
                statusImageView.setImageResource(R.drawable.loading_animation)
            }
            MoviesApiStatus.ERROR -> {
                statusImageView.visibility = ImageView.VISIBLE
                statusImageView.setImageResource(R.drawable.ic_connection_error)
            }
            MoviesApiStatus.DONE -> {
                statusImageView.visibility = ImageView.GONE
            }
            else -> {}
        }
    }

