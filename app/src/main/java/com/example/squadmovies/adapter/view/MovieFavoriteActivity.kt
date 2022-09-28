package com.example.squadmovies.adapter.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.squadmovies.R
import com.example.squadmovies.databinding.ActivityFavoriteBinding

class MovieFavoriteActivity : AppCompatActivity() {
    private val bindind by lazy { ActivityFavoriteBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindind.root)
        setupIconBack()
    }
    private fun setupIconBack() {
        bindind.toolbarFavorite.setNavigationIcon(R.drawable.ic_back)
        bindind.toolbarFavorite.setNavigationOnClickListener(
            View.OnClickListener {
                onBackPressed()
                true
            }
        )
    }
}
