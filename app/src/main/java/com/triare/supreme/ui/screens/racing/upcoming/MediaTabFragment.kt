package com.triare.supreme.ui.screens.racing.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.triare.supreme.R
import com.triare.supreme.ui.dvo.RacingDvo
import com.triare.supreme.ui.models.CircuitViewModel

class MediaTabFragment : Fragment() {

    private val circuitViewModel by viewModels<CircuitViewModel>()
    private var dataRacing: RacingDvo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_media_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        observeUpdates()
    }

    private fun initArgs() {
        arguments?.let {
            if (it.containsKey(KEY_DATA_CIRCUIT_ARGS)) {
                dataRacing = arguments?.get(KEY_DATA_CIRCUIT_ARGS) as RacingDvo?
            }
        }
    }

    private fun initUi() {
        initNewsRecycler()
    }

    private fun observeUpdates() {

    }

    private fun initNewsRecycler() {

    }

    companion object {
        private const val KEY_DATA_CIRCUIT_ARGS = "MediaRef"
        fun newInstance(dataRacing: RacingDvo): CircuitTabFragment {
            val args = bundleOf(KEY_DATA_CIRCUIT_ARGS to dataRacing)

            val racingUpcCircuitTabFragment = CircuitTabFragment()
            racingUpcCircuitTabFragment.arguments = args

            return racingUpcCircuitTabFragment
        }
    }
}