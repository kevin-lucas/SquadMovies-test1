package com.example.squadmovies.view.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.squadmovies.R
import com.example.squadmovies.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    private val bindind by lazy { ActivityFavoriteBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindind.root)
        setupMenu()
    }
    private fun setupMenu() {
        bindind.toolbarFavorite.setNavigationIcon(R.drawable.ic_back)
        bindind.toolbarFavorite.setNavigationOnClickListener(
            View.OnClickListener {
                onBackPressed()
                true
            }
        )
    }
}
