package com.example.squadmovies.projeto.view

import IClickItemMovieListener
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.squadmovies.R
import com.example.squadmovies.data.respository.AllMoviesRepository
import com.example.squadmovies.data.respository.ByTitleMovieRepository
import com.example.squadmovies.databinding.ActivityMainBinding
import com.example.squadmovies.domain.entities.Movie
import com.example.squadmovies.domain.usecase.IAllMovieUseCase
import com.example.squadmovies.domain.usecase.MovieByTitleUseCase
import com.example.squadmovies.projeto.adapter.MovieAdapter
import com.example.squadmovies.projeto.network.IRetrofitService
import com.example.squadmovies.projeto.utils.Constants
import com.example.squadmovies.projeto.viewModel.MovieListViewModel

class MovieListMainActivity : AppCompatActivity(), IClickItemMovieListener {

    private lateinit var movieAdapter: MovieAdapter
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            MovieListViewModel.MovieViewModelFactory(
                IAllMovieUseCase(AllMoviesRepository(IRetrofitService.getBaseUrl())),
                MovieByTitleUseCase(ByTitleMovieRepository(IRetrofitService.getBaseUrl()))
            )

        )[MovieListViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupMenu()
        setupButtonBack()
        callingReuestApi()
        setupObservers()
        setupOnChangeListeners()
    }

    private fun initAdapter(list: List<Movie>) {
        this.movieAdapter = MovieAdapter(this)
        binding.recyclerviewMovies.layoutManager = LinearLayoutManager(this@MovieListMainActivity)
        binding.recyclerviewMovies.setHasFixedSize(true)
        binding.recyclerviewMovies.adapter = movieAdapter
        with(movieAdapter) { submitList(list) }
    }

    private fun setupObservers() {
        viewModel.listMovieLiveData.observe(this) { movies ->
            if (!movies.isNullOrEmpty()) {
                initAdapter(movies)
            }
        }

        viewModel.errorMessage.observe(this) { message ->
            Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show()
        }
    }
    private fun setupOnChangeListeners() {
        binding.editText.doOnTextChanged { text, start, before, count ->

            if (text?.length!! > 2) {
                viewModel.getTitle(text.toString())
            }
        }
    }
    private fun callingReuestApi() {
        viewModel.getMovies()
    }

    private fun setupMenu() {
        binding.toolbarMain.inflateMenu(R.menu.menu_toolbar)
        binding.toolbarMain.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.favorite -> {
                    startActivity(Intent(this@MovieListMainActivity, MovieFavoriteActivity::class.java))
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun setupButtonBack() {
        binding.toolbarMain.setNavigationIcon(R.drawable.ic_back)
        binding.toolbarMain.setNavigationOnClickListener(
            View.OnClickListener {
                onBackPressed()
                true
            }
        )
    }

    private fun callScreenDetailsMovies(movie: Movie) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_MOVIE_ID, movie.imdbID)
        startActivity(intent)
    }

    override fun onItemClikListener(movie: Movie) {
        callScreenDetailsMovies(movie)
    }
}
