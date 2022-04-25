package com.triare.supreme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.triare.supreme.R
import com.triare.supreme.ui.screens.news.NewsFragment
import com.triare.supreme.ui.screens.racing.RacingFragment
import com.triare.supreme.ui.screens.standings.StandingsFragment

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
                R.id.news -> replaceFragment(NewsFragment.newInstance())
                R.id.racing -> replaceFragment(RacingFragment.newInstance())
                R.id.standings -> replaceFragment(StandingsFragment.newInstance())
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .addToBackStack("app")
            .commit()
    }
}