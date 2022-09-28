package com.example.squadmovies.projeto.view

import Onclik
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.squadmovies.R
import com.example.squadmovies.databinding.ActivityMainBinding
import com.example.squadmovies.projeto.adapter.MovieAdapter
import com.example.squadmovies.projeto.model.MovieResponse
import com.example.squadmovies.projeto.viewModel.MovieViewModel

class MovieMainActivity : AppCompatActivity(), Onclik {
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
        setupButtonBack()
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
        binding.recyclerviewMovies.layoutManager = LinearLayoutManager(this@MovieMainActivity)
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

    override fun onClickMovie(onclik: MovieResponse) {
       callScreenDetailsMovies()
    }


 private fun callScreenDetailsMovies(){
     val intent = Intent(this,MovieDetailsActivity::class.java)
     startActivity(intent)
 }


}



