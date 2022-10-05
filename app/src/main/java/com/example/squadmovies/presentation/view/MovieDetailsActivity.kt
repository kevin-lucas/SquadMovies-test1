package com.example.squadmovies.projeto.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.squadmovies.R
import com.example.squadmovies.databinding.ActivityMovieDetailsBinding
import com.example.squadmovies.data.model.MovieResponse
import com.example.squadmovies.projeto.utils.Constants

class MovieDetailsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMovieDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupIconBack()
        //  viewModel.getMovie(listOf())
        val imdb = intent.getStringExtra(Constants.EXTRA_MOVIE_ID)
        // Toast.makeText(this, m.toString(), Toast.LENGTH_SHORT).show())
        imdb.let {
            if (imdb != null) {
            }
        }
    }

    fun setMovieDetailsInScreen(movie: MovieResponse) {
        Glide.with(binding.root.context)
            .load(movie.poster)
            .into(binding.imgDetails)
        binding.textMovieDetails.text = movie.language
        binding.textMoviePlot.text = movie.plot
    }

    private fun setupIconBack() {
        binding.toolbarMovieDetails.setNavigationIcon(R.drawable.ic_back)
        binding.toolbarMovieDetails.setNavigationOnClickListener(
            View.OnClickListener {
                onBackPressed()
                true
            }
        )
    }
}
private fun setupObservers() {
}
