package com.example.squadmovies.projeto.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.squadmovies.R
import com.example.squadmovies.projeto.adapter.MovieAdapter
import com.example.squadmovies.projeto.viewModel.MovieViewModel
import com.example.squadmovies.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieViewModel

    private lateinit var movieAdapter: MovieAdapter
    private val binding by lazy {
        ActivityMovieDetailsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        setupIconBack()
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
