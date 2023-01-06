package com.example.jmdb.screens.overviewfavourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jmdb.R
import com.example.jmdb.databinding.FragmentOverviewFavouritesBinding
import com.example.jmdb.databinding.FragmentOverviewMoviesBinding

class OverviewFavouritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOverviewFavouritesBinding.inflate(inflater, container, false)

        return binding.root
        //return inflater.inflate(R.layout.fragment_overview_favourites, container, false)
    }
}