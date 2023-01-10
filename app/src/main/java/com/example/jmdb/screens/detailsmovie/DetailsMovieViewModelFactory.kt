package com.example.jmdb.screens.detailsmovie

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jmdb.network.Movie



class DetailsMovieViewModelFactory( private val movie: Movie, private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsMovieViewModel::class.java)) {
            return DetailsMovieViewModel(movie, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
