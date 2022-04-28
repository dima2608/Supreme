package com.triare.supreme.ui.screens.racing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.triare.supreme.R
import com.triare.supreme.ui.adapters.RacingPagerAdapter
import com.triare.supreme.ui.models.RacingViewModel

class RacingFragment : Fragment() {

    private val raceViewModel by viewModels<RacingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_racing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = view.findViewById<TabLayout>(R.id.racing_tabL)
        val tabPager = view.findViewById<ViewPager2>(R.id.racing_pager)

        val adapter = RacingPagerAdapter(childFragmentManager, lifecycle)

        tabPager.adapter = adapter
         TabLayoutMediator(tabLayout,tabPager){tab, position ->
             when(position) {
                 0 -> tab.text = "UPCOMING"
                 1 -> tab.text = "PREVIOUS"
             }
         }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = RacingFragment()
    }
}