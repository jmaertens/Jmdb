package com.example.jmdb.screens.overviewmovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.jmdb.R
import com.example.jmdb.databinding.FragmentOverviewMoviesBinding
import com.example.jmdb.databinding.GridViewItemBinding
import android.view.*
import androidx.navigation.Navigation

class OverviewMoviesFragment : Fragment() {

    private val viewModel: OverviewMoviesViewModel by lazy {
        ViewModelProvider(this).get(OverviewMoviesViewModel::class.java)
    }

    private lateinit var binding: FragmentOverviewMoviesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOverviewMoviesBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        //Set binding.Postergridadapter to a new postergridadapter
        binding.posterGrid.adapter = PosterGridAdapter(PosterGridAdapter.OnClickListener {
            viewModel.displayPropertyDetails(it)
        })

        //Observe navigateToSelectedProperty, navigate when Movie !null, then call displayPropertyDetailsComplete()
        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(OverviewMoviesFragmentDirections.actionShowDetail(it))
                viewModel.displayPropertyDetailsComplete()
            }
        })



        return binding.root
    }
}