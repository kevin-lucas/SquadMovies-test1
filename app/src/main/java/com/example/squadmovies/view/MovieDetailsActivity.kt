package com.example.squadmovies.projeto.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.squadmovies.R
import com.example.squadmovies.databinding.ActivityMovieDetailsBinding
import com.example.squadmovies.projeto.utils.Constants
import com.example.squadmovies.projeto.viewModel.MovieDetailsViewModel

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieDetailsViewModel

    private val binding by lazy {
        ActivityMovieDetailsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)
        setupIconBack()
        //recoverDataDetails(listOf())
    }
//
//    private fun recoverDataDetails(id: List<Any>) {
//        intent.getStringArrayExtra(Constants.EXTRA_MOVIE_ID)
//        Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()
//        viewModel.getDetailsMovies(id)
//    }

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
