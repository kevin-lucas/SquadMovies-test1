package com.example.squadmovies.projeto.view

import IClickItemMovieListener
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.squadmovies.R
import com.example.squadmovies.data.respository.MovieRepository
import com.example.squadmovies.databinding.ActivityMainBinding
import com.example.squadmovies.domain.usecase.MovieUseCase
import com.example.squadmovies.projeto.adapter.MovieAdapter
import com.example.squadmovies.projeto.model.MovieResponse
import com.example.squadmovies.projeto.network.IRetrofitService
import com.example.squadmovies.projeto.utils.Constants
import com.example.squadmovies.projeto.viewModel.MovieViewModel

class MovieMainActivity : AppCompatActivity(), IClickItemMovieListener {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            MovieViewModel.MovieViewModelFactory(
                MovieUseCase(MovieRepository(IRetrofitService.getBaseUrl()))
            )

        )
            .get(MovieViewModel::class.java)
    }

    private val sharedPreference by lazy {
        getSharedPreferences(
            "Dados_persistidos",
            Context.MODE_PRIVATE
        )
    }
    private lateinit var movieAdapter: MovieAdapter
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupMenu()
        setupButtonBack()
        initAdapter(arrayListOf())
        setupObservers()
        viewModel.getMovies()
        setupOnChangeListeners()
    }

    private fun initAdapter(list: List<MovieResponse>) {
        this.movieAdapter = MovieAdapter(this)
        binding.recyclerviewMovies.layoutManager = LinearLayoutManager(this@MovieMainActivity)
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
        viewModel.listMovieLiveData.observe(this) { movies ->
        }
    }

    private fun setupOnChangeListeners() {
        binding.editText.doOnTextChanged { text, start, before, count ->
            // viewModel.getMovieByTitle(text.toString())
        }
    }

    private fun setupMenu() {
        binding.toolbarMain.inflateMenu(R.menu.menu_toolbar)
        binding.toolbarMain.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.favorite -> {
                    startActivity(Intent(this@MovieMainActivity, MovieFavoriteActivity::class.java))
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

    private fun callScreenDetailsMovies(movie: MovieResponse) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_MOVIE_ID, movie.imdbID)
        startActivity(intent)
    }

    override fun onItemClikListener(movie: MovieResponse) {
        //  callScreenDetailsMovies(movie)
    }
}
//    private fun salvarDados() {
//        val sharedPreferencesEditor = sharedPreference.edit()
//            sharedPreferencesEditor.putString(
//            sharedPreferencesEditor.apply()
//    }
