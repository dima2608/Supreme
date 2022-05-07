package com.triare.supreme.ui.screens.racing.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.triare.supreme.R
import com.triare.supreme.ui.dvo.RacingDvo
import com.triare.supreme.ui.models.CircuitViewModel

class CircuitTabFragment : Fragment() {

    private val circuitViewModel by viewModels<CircuitViewModel>()
    private var dataRacing: RacingDvo? = null
    private var title: TextView? = null
    private var icon: ImageView? = null
    private var distance: TextView? = null
    private var length: TextView? = null
    private var record: TextView? = null
    private var recordDriver: TextView? = null
    private var laps: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_circuit_tab, container, false)
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
        title = view?.findViewById(R.id.circuit_title)
        icon = view?.findViewById(R.id.circuit_icon)
        distance = view?.findViewById(R.id.race_distance_km)
        length = view?.findViewById(R.id.circuit_length_km)
        record = view?.findViewById(R.id.lap_record_min)
        recordDriver = view?.findViewById(R.id.lap_record_name)
        laps = view?.findViewById(R.id.laps_num)
    }

    private fun observeUpdates() {
        circuitViewModel.observeCircuits(dataRacing?.circuit!!)
        circuitViewModel.circuitLiveData.observe(viewLifecycleOwner) {
            val circuit = it ?: return@observe
            title?.text = circuit.title
            distance?.text = circuit.distance
            length?.text = circuit.length
            record?.text = circuit.record
            recordDriver?.text = circuit.recordDriver
            laps?.text = circuit.laps

            Glide.with(this)
                .load(circuit.icon)
                .centerInside()
                .into(icon!!)
        }
    }

    companion object {
        private const val KEY_DATA_CIRCUIT_ARGS = "CircuitRef"
        fun newInstance(dataRacing: RacingDvo): CircuitTabFragment {
            val args = bundleOf(KEY_DATA_CIRCUIT_ARGS to dataRacing)

            val racingUpcCircuitTabFragment = CircuitTabFragment()
            racingUpcCircuitTabFragment.arguments = args

            return racingUpcCircuitTabFragment
        }
    }
}