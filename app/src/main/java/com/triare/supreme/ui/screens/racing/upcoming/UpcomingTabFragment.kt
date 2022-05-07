package com.triare.supreme.ui.screens.racing.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.triare.supreme.R
import com.triare.supreme.ui.adapters.UpcomingPagerAdapter
import com.triare.supreme.ui.dvo.RacingDvo

class UpcomingTabFragment : Fragment() {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming_tab, container, false)
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
        round = view?.findViewById(R.id.racing_Upc_round)
        date = view?.findViewById(R.id.racing_Upc_date)
        country = view?.findViewById(R.id.racing_Upc_country_name)
        circuitName = view?.findViewById(R.id.racing_Upc_circle_name)
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
        val tabLayout = view?.findViewById<TabLayout>(R.id.racing_Upc_tabL)
        val tabPager = view?.findViewById<ViewPager2>(R.id.racing_Upc_pager)
        val adapter = dataRacing?.let { UpcomingPagerAdapter(childFragmentManager, lifecycle) }

        adapter?.data = dataRacing

        tabPager?.adapter = adapter
        TabLayoutMediator(tabLayout!!, tabPager!!) { tab, position ->
            when (position) {
                0 -> tab.text = "CIRCUIT"
                1 -> tab.text = "MEDIA"
            }
        }.attach()
    }

    companion object {
        private const val KEY_DATA_RACING_ARGS = "RacingDvo"
        fun newInstance(dataRacing: RacingDvo): UpcomingTabFragment {
            val args = bundleOf(KEY_DATA_RACING_ARGS to dataRacing)

            val racingUpcomingCircuitFragment = UpcomingTabFragment()
            racingUpcomingCircuitFragment.arguments = args

            return racingUpcomingCircuitFragment
        }
    }
}