package com.triare.supreme.ui.screens.racing.previous

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.triare.supreme.R
import com.triare.supreme.ui.adapters.PreviousPagerAdapter
import com.triare.supreme.ui.adapters.UpcomingPagerAdapter
import com.triare.supreme.ui.dvo.RacingDvo
import com.triare.supreme.ui.screens.racing.upcoming.UpcomingTabFragment

class PreviousTabFragment : Fragment() {

    private var dataRacing: RacingDvo? = null
    private var round: TextView? = null
    private var date: TextView? = null
    private var country: TextView? = null
    private var circuitName: TextView? = null
    private var btnGoBack: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_previous_tab, container, false)
    }
    private fun initArgs() {
        arguments?.let {
            if (it.containsKey(KEY_DATA_RACING_ARGS)) {
                dataRacing = arguments?.get(KEY_DATA_RACING_ARGS) as RacingDvo?
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        renderUi()
        initTab()
    }

    private fun initUi() {
        round = view?.findViewById(R.id.racing_prv_round)
        date = view?.findViewById(R.id.racing_prv_date)
        country = view?.findViewById(R.id.racing_prv_country_name)
        circuitName = view?.findViewById(R.id.racing_prv_circle_name)
        btnGoBack = view?.findViewById(R.id.arrow_back)
    }

    private fun renderUi() {
        round?.text = dataRacing?.round
        date?.text = dataRacing?.date
        country?.text = dataRacing?.country
        circuitName?.text = dataRacing?.circuitName

        goBack()
    }

    private fun goBack() {
        btnGoBack?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun initTab() {
        val tabLayout = view?.findViewById<TabLayout>(R.id.racing_prv_tabL)
        val tabPager = view?.findViewById<ViewPager2>(R.id.racing_Pre_pager)
        val adapter = dataRacing?.let { PreviousPagerAdapter(childFragmentManager, lifecycle) }

        adapter?.data = dataRacing

        tabPager?.adapter = adapter
        TabLayoutMediator(tabLayout!!, tabPager!!) { tab, position ->
            when (position) {
                0 -> tab.text = "OVERVIEW"
                1 -> tab.text = "HIGHLIGHTS"
            }
        }.attach()
    }

    companion object {
        private const val KEY_DATA_RACING_ARGS = "RacingDvo"
        fun newInstance(dataRacing: RacingDvo): PreviousTabFragment {
            val args = bundleOf(KEY_DATA_RACING_ARGS to dataRacing)

            val previousTabFragment = PreviousTabFragment()
            previousTabFragment.arguments = args

            return previousTabFragment
        }
    }
}