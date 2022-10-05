package com.example.squadmovies.projeto.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.squadmovies.R
import com.example.squadmovies.data.respository.GetIdMovieRepository
import com.example.squadmovies.databinding.ActivityMovieDetailsBinding
import com.example.squadmovies.domain.entities.Movie
import com.example.squadmovies.domain.usecase.IMovieGetIdUsecase
import com.example.squadmovies.presentation.viewModel.MovieDetailsViewModel
import com.example.squadmovies.projeto.network.IRetrofitService
import com.example.squadmovies.projeto.utils.Constants

class MovieDetailsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMovieDetailsBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            MovieDetailsViewModel.MovieDetailsViewModelFactory(
                IMovieGetIdUsecase(GetIdMovieRepository(IRetrofitService.getBaseUrl()))
            )

        )[MovieDetailsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupIconBack()
        loadMovieDetails()
        setupObservers()
    }

    private fun loadMovieDetails() {
        val imdb = intent.getStringExtra(Constants.EXTRA_MOVIE_ID)
        imdb.let {
            if (imdb != null) {
                viewModel.getResultDetailsMovie(imdb)
            }
        }
    }
    private fun setupObservers() {
        viewModel.movieLiveData.observe(this) { movie ->
            setMovieDetails(movie)
        }
    }

    private fun setMovieDetails(movie: Movie?) {
        Glide.with(binding.root.context)
            .load(movie!!.poster)
            .into(binding.imgDetails)
        binding.textMovieLanguague.text = movie.language
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
