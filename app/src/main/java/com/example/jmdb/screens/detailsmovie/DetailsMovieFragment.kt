package com.example.jmdb.screens.detailsmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jmdb.R
import com.example.jmdb.databinding.FragmentDetailsMovieBinding
import com.example.jmdb.databinding.FragmentOverviewMoviesBinding

class DetailsMovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDetailsMovieBinding.inflate(inflater, container, false)

        return binding.root
        //return inflater.inflate(R.layout.fragment_details_movie, container, false)
    }
}