package com.example.squadmovies.projeto.adapter

import IClickItemMovieListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.squadmovies.databinding.ResItemUserBinding
import com.example.squadmovies.projeto.model.MovieResponse

class MovieAdapter(private val onClick: IClickItemMovieListener) :
    ListAdapter<MovieResponse, MovieAdapter.MovieViewHolder>(
        MovieResponseCallback()
    ),IClickItemMovieListener{

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


    override fun onItemClikListener(movie: MovieResponse) {
        TODO("Not yet implemented")
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
