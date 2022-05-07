package com.triare.supreme.ui.screens.racing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.triare.supreme.R
import com.triare.supreme.ui.adapters.RacingAdapter
import com.triare.supreme.ui.dvo.RacingDvo
import com.triare.supreme.ui.models.RacingViewModel
import com.triare.supreme.ui.screens.racing.previous.PreviousTabFragment

class RacingPreviousFragment : Fragment(), RacingAdapter.OnItemClickListener {

    private val racingViewModel by viewModels<RacingViewModel>()
    private lateinit var racingAdaptor: RacingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_racing_previous, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        observeUpdates()

    }

    private fun initUi() {
        initRecycler()
    }

    private fun initRecycler() {
        val racesRecycler = view?.findViewById<RecyclerView>(R.id.recycler_view_racing_previous)
        racesRecycler?.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            racingAdaptor = RacingAdapter(context, this@RacingPreviousFragment)
            adapter = racingAdaptor
        }
    }

    private fun observeUpdates() {
        racingViewModel.observePreviousRaces()
        racingViewModel.racePreviousLiveData.observe(viewLifecycleOwner) {
            val races = it ?: return@observe
            racingAdaptor.submitRacingList(races)
        }
    }

    override fun onItemClick(data: RacingDvo) {
        val detailsFragment = PreviousTabFragment.newInstance(data)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, detailsFragment)
            .addToBackStack("item")
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = RacingPreviousFragment()
    }
}