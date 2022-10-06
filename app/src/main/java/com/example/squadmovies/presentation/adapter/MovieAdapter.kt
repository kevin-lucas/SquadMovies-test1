package com.example.squadmovies.presentation.adapter

import IClickItemMovieListener
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.squadmovies.databinding.ResItemUserBinding
import com.example.squadmovies.domain.entities.MovieDomainEntities

class MovieAdapter(private val onClick: IClickItemMovieListener, private val context: Context) :
    ListAdapter<MovieDomainEntities, MovieAdapter.MovieViewHolder>(
        MovieResponseCallback()
    ) {

    //  val onItemClick :((MovieDetailsResponse)->Unit)? = null

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
        holder.itemView.setOnClickListener {
            onClick.onItemClikListener(itemMovie)
        }
    }

    class MovieResponseCallback : DiffUtil.ItemCallback<MovieDomainEntities>() {
        override fun areItemsTheSame(
            oldItem: MovieDomainEntities,
            newItem: MovieDomainEntities
        ): Boolean {
            return oldItem.year == newItem.year
        }

        override fun areContentsTheSame(
            oldItem: MovieDomainEntities,
            newItem: MovieDomainEntities
        ): Boolean {
            return oldItem.title == newItem.title
        }
    }
}




