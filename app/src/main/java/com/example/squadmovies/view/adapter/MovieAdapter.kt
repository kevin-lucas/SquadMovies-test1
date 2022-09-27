package com.example.squadmovies.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.squadmovies.databinding.ResItemUserBinding
import com.example.squadmovies.view.model.MovieResponse

class MovieAdapter(private val context: Context) : ListAdapter<MovieResponse, MovieAdapter.MovieViewHolder>(
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
        val item = getItem(position)
        holder.binding.txtTituloMovie.text = item.title
        holder.binding.txtYearMovie.text = item.year

        Glide.with(holder.binding.root.context)
            .load(item.poster)
            .into(holder.binding.moviesPoster)
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
