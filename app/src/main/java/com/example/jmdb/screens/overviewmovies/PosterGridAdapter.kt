package com.example.jmdb.screens.overviewmovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jmdb.databinding.GridViewItemBinding
import com.example.jmdb.network.Movie


//Create PosterGridAdapter that extends the RecyclerView ListAdapter with DiffCallback
class PosterGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<Movie, PosterGridAdapter.MovieViewHolder>(DiffCallback) {


    //The MovieViewHolder constructor takes the binding variable from the associated
    //     GridViewItem, which nicely gives it access to the full [Movie] information.
    class MovieViewHolder(private val binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.property = movie
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(movie)
        }
        holder.bind(movie)
    }

    //Named lambda
    class OnClickListener(val clickListener: (movie: Movie) -> Unit) {
        fun onClick(movie: Movie) = clickListener(movie)
    }
}