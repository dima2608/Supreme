package com.triare.supreme.ui.screens.racing.previous

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.triare.supreme.R
import com.triare.supreme.ui.adapters.NewsAdapter
import com.triare.supreme.ui.adapters.PodiumAdapter
import com.triare.supreme.ui.dvo.RacingDvo
import com.triare.supreme.ui.models.CircuitViewModel
import com.triare.supreme.ui.screens.racing.upcoming.CircuitTabFragment

class OverviewTabFragment : Fragment() {

    private val overviewViewModel by viewModels<CircuitViewModel>()
    private lateinit var overviewAdaptor: PodiumAdapter
    private var dataRacing: RacingDvo? = null
    private var time: TextView? = null
    private var icon: ImageView? = null
    private var lap: TextView? = null
    private var driver: TextView? = null
    private var constructor: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_overview_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        observeUpdates()
    }

    private fun initArgs() {
        arguments?.let {
            if (it.containsKey(KEY_DATA_OVERVIEW_ARGS)) {
                dataRacing = arguments?.get(KEY_DATA_OVERVIEW_ARGS) as RacingDvo?
            }
        }
    }

    private fun initUi() {
        time = view?.findViewById(R.id.overview_time)
        icon = view?.findViewById(R.id.icon_overview)
        lap = view?.findViewById(R.id.overview_laps)
        driver = view?.findViewById(R.id.overview_driver)
        constructor = view?.findViewById(R.id.overview_constructor)
        initRecycler()
    }

    private fun observeUpdates() {
        dataRacing?.overview?.let { overviewViewModel.observeOverview(it) }
        overviewViewModel.overviewLiveData.observe(viewLifecycleOwner) {
            val overview = it ?: return@observe
            val fastestLap = overview.fastestLap
            overviewAdaptor.submitPodiumList(overview.results!!)
            time?.text = fastestLap?.time
            lap?.text = fastestLap?.lap
            driver?.text = fastestLap?.driver
            constructor?.text = fastestLap?.constructor

            Glide.with(this)
                .load(fastestLap?.icon)
                .centerInside()
                .into(icon!!)
        }
    }

    private fun initRecycler() {
        val podiumRecycler = view?.findViewById<RecyclerView>(R.id.recycler_view_overview)
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_divider)!!)
        podiumRecycler?.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            overviewAdaptor = PodiumAdapter(context)
            adapter = overviewAdaptor
            podiumRecycler.addItemDecoration(divider)
        }
    }

    companion object {
        private const val KEY_DATA_OVERVIEW_ARGS = "OverviewRef"
        fun newInstance(dataRacing: RacingDvo): OverviewTabFragment {
            val args = bundleOf(KEY_DATA_OVERVIEW_ARGS to dataRacing)

            val overviewTabFragment = OverviewTabFragment()
            overviewTabFragment.arguments = args

            return overviewTabFragment
        }
    }
}