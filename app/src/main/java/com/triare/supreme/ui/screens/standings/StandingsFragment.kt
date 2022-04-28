package com.triare.supreme.ui.screens.standings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.triare.supreme.R
import com.triare.supreme.ui.adapters.RacingAdapter
import com.triare.supreme.ui.adapters.StandingsAdapter
import com.triare.supreme.ui.models.RacingViewModel
import com.triare.supreme.ui.models.StandingsViewModel

class StandingsFragment : Fragment() {

    private val standingsViewModel by viewModels<StandingsViewModel>()
    private lateinit var standingsAdaptor: StandingsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        observeStandings()
    }

    private fun initUi() {
        initRecycler()
    }

    private fun observeStandings() {
        standingsViewModel.observeStandings()
        standingsViewModel.standingsLiveData.observe(viewLifecycleOwner) {
            val standings = it?: return@observe
            standingsAdaptor.submitRacingList(standings)
        }
    }

    private fun initRecycler() {
        val recycler = view?.findViewById<RecyclerView>(R.id.recycler_view_standings)
        recycler?.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            standingsAdaptor = StandingsAdapter(context)
            adapter = standingsAdaptor
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = StandingsFragment()

    }
}