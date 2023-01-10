package com.example.jmdb.screens.overviewmovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.jmdb.R
import com.example.jmdb.databinding.FragmentOverviewMoviesBinding
import com.example.jmdb.databinding.GridViewItemBinding

class OverviewMoviesFragment : Fragment() {

    private val viewModel: OverviewMoviesViewModel by lazy {
        ViewModelProvider(this).get(OverviewMoviesViewModel::class.java)
    }

    private lateinit var binding: GridViewItemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = GridViewItemBinding.inflate(inflater, container, false)


        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel


        /*binding.detailsButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_overviewMoviesFragment_to_detailsMovieFragment)
        }*/


        return binding.root
    }
}