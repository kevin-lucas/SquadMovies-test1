package com.example.squadmovies.view.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.squadmovies.R
import com.example.squadmovies.databinding.ActivityMainBinding
import com.example.squadmovies.view.adapter.MovieAdapter
import com.example.squadmovies.view.model.MovieResponse
import com.example.squadmovies.view.viewModel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MovieViewModel

    private lateinit var movieAdapter: MovieAdapter
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        setupMenu()
        requestApi()
        setupAdapter(arrayListOf())
        setupOnChangeListeners()
        setupObservers()
    }

    fun setupOnChangeListeners() {
        binding.editText.doOnTextChanged { text, start, before, count ->
            viewModel.getMoviesByTitle(text.toString())
        }
    }

    fun setupAdapter(list: List<MovieResponse>) {
        this.movieAdapter = MovieAdapter(this)
        binding.recyclerviewMovies.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recyclerviewMovies.setHasFixedSize(true)
        binding.recyclerviewMovies.adapter = movieAdapter
        with(movieAdapter) { submitList(list) }
    }

    private fun setupObservers() {
        viewModel.listMovieLiveData.observe(this) { moveis ->
            if (!moveis.isNullOrEmpty()) {
                setupAdapter(moveis)
            }
        }

        viewModel.erroMessage.observe(this) { message ->
            Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestApi() {
        viewModel.getAllMovies()
    }

    private fun setupMenu() {
        binding.toolbarMain.inflateMenu(R.menu.menu_toolbar)
        binding.toolbarMain.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.favorite -> {
                    startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}
