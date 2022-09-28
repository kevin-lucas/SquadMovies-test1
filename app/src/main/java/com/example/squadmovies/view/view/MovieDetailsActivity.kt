package com.example.squadmovies.view.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.squadmovies.R
import com.example.squadmovies.databinding.ActivityMainBinding
import com.example.squadmovies.view.adapter.MovieAdapter
import com.example.squadmovies.view.viewModel.MovieViewModel

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieViewModel

    private lateinit var movieAdapter: MovieAdapter
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
    }
}