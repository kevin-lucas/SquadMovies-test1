package com.example.squadmovies.view.adapter

import Onclik
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.squadmovies.databinding.ResItemUserBinding
import com.example.squadmovies.view.model.MovieResponse

class MovieAdapter(private val onclick: Onclik) :
    ListAdapter<MovieResponse, MovieAdapter.MovieViewHolder>(
        MovieResponseCallback()
    ), Onclik {

    override fun onClickMovie(onclick: MovieResponse) {
    }
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
        Glide.with(holder.binding.root.context)
            .load(itemMovie.poster)
            .into(holder.binding.moviesPoster)

        holder.binding.txtTituloMovie.text = itemMovie.title
        holder.binding.txtMovieYear.text = itemMovie.year
        holder.itemView.setOnClickListener {
            onclick.onClickMovie(itemMovie)
        }
    }
}

class MovieResponseCallback : DiffUtil.ItemCallback<MovieResponse>() {
    override fun areItemsTheSame(oldItem: MovieResponse, newItem: MovieResponse): Boolean {
        return oldItem.title == newItem.language
    }

    override fun areContentsTheSame(oldItem: MovieResponse, newItem: MovieResponse): Boolean {
        return oldItem.title == newItem.year
    }
}
