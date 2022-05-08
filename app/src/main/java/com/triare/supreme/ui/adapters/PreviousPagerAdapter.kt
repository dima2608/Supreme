package com.triare.supreme.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.triare.supreme.ui.dvo.RacingDvo
import com.triare.supreme.ui.screens.racing.previous.HighlightsTabFragment
import com.triare.supreme.ui.screens.racing.previous.OverviewTabFragment
import com.triare.supreme.ui.screens.racing.upcoming.CircuitTabFragment
import com.triare.supreme.ui.screens.racing.upcoming.MediaTabFragment

class PreviousPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    var data: RacingDvo? = null

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OverviewTabFragment.newInstance(data!!)
            1 -> HighlightsTabFragment.newInstance(data!!)
            else -> {
                Fragment()
            }
        }
    }
}