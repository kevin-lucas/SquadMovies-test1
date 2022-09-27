package com.example.squadmovies.view.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.squadmovies.R
import com.example.squadmovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupMenu()
    }

    private fun setupMenu() {
        binding.toolbarMain.inflateMenu(R.menu.menu_toolbar)
        binding.toolbarMain.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.favorite -> {
                    startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))
                    true
                }
                else -> { false }
            }
        }
    }
}

