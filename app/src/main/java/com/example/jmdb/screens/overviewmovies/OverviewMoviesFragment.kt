package com.example.jmdb.screens.overviewmovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import com.example.jmdb.R
import com.example.jmdb.databinding.FragmentOverviewMoviesBinding


class OverviewMoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOverviewMoviesBinding.inflate(inflater, container, false)

        binding.detailsButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_overviewMoviesFragment_to_detailsMovieFragment)
        }


        return binding.root
        //return inflater.inflate(R.layout.fragment_overview_movies, container, false)
    }

}