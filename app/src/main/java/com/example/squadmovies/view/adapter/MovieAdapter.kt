package com.example.squadmovies.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.squadmovies.databinding.ResItemUserBinding
import com.example.squadmovies.view.model.MovieResponse
import com.example.squadmovies.view.view.MovieMainActivity

class MovieAdapter(private val clickMovie: MovieMainActivity) : ListAdapter<MovieResponse, MovieAdapter.MovieViewHolder>(
    MovieResponseCallback()
) {

    inner class MovieViewHolder(val binding: ResItemUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            ResItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val itemMovie = getItem(position)
        itemMovie?.let {
            Glide.with(holder.binding.root.context)
                .load(itemMovie.poster)
                .into(holder.binding.moviesPoster)

            holder.binding.txtTituloMovie.text = itemMovie.title
            holder.binding.txtMovieYear.text = itemMovie.year
        }
    }
}

class MovieResponseCallback : DiffUtil.ItemCallback<MovieResponse>() {
    override fun areItemsTheSame(
        oldItem: MovieResponse,
        newItem: MovieResponse
    ): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: MovieResponse,
        newItem: MovieResponse
    ): Boolean {
        return oldItem.title == newItem.title
    }
}
