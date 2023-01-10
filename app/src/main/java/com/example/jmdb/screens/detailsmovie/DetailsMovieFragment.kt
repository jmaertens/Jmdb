package com.example.jmdb.screens.detailsmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.jmdb.R
import com.example.jmdb.databinding.FragmentDetailsMovieBinding
import com.example.jmdb.databinding.FragmentOverviewMoviesBinding

class DetailsMovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(this.activity).application
        // Inflate the layout for this fragment
        val binding = FragmentDetailsMovieBinding.inflate(inflater, container, false)
        binding.setLifecycleOwner(this)

        //Get the selectedProperty from the arguments bundle
        val movie = DetailsMovieFragmentArgs.fromBundle(requireArguments()).selectedProperty

        //Create the DetailsMovieViewmodelFactory and set it in the binding
        val viewModelFactory = DetailsMovieViewModelFactory(movie, application)

        //Get the detailviewmodel from the detailviewmodelfactory and set it in the binding
        binding.viewModel = ViewModelProvider(this, viewModelFactory).get(DetailsMovieViewModel::class.java)

        return binding.root
        //return inflater.inflate(R.layout.fragment_details_movie, container, false)
    }
}