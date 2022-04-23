package com.triare.supreme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.triare.supreme.R
import com.triare.supreme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        initBottomNav()
    }

    private fun initBottomNav() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.news -> true
                R.id.racing -> true
                R.id.standings -> true
            }
            true
        }
    }
}