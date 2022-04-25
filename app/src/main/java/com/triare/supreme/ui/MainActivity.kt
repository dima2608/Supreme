package com.triare.supreme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.triare.supreme.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initUi()
    }

    private fun initUi() {
        initBottomNav()
    }

    private fun initBottomNav() {
        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.news -> true
                R.id.racing -> true
                R.id.standings -> true
            }
            true
        }
    }
}