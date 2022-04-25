package com.triare.supreme.ui.adapters
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.triare.supreme.ui.screens.racing.RacingPreviousFragment
import com.triare.supreme.ui.screens.racing.RacingUpcomingFragment

class RacingPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0 -> RacingUpcomingFragment.newInstance()
            1 -> RacingPreviousFragment.newInstance()
           else -> {Fragment()}
       }
    }
}