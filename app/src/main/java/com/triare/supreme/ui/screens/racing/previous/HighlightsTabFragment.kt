package com.triare.supreme.ui.screens.racing.previous

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.triare.supreme.R
import com.triare.supreme.ui.dvo.RacingDvo

class HighlightsTabFragment : Fragment() {

    private var dataRacing: RacingDvo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_highlights_tab, container, false)
    }

    private fun initArgs() {
        arguments?.let {
            if (it.containsKey(KEY_DATA_HIGHLIGHTS_ARGS)) {
                dataRacing = arguments?.get(KEY_DATA_HIGHLIGHTS_ARGS) as RacingDvo?
            }
        }
    }

    companion object {
        private const val KEY_DATA_HIGHLIGHTS_ARGS = "HighlightsRef"
        fun newInstance(dataRacing: RacingDvo): HighlightsTabFragment {
            val args = bundleOf(KEY_DATA_HIGHLIGHTS_ARGS to dataRacing)

            val highlightsTabFragment = HighlightsTabFragment()
            highlightsTabFragment.arguments = args

            return highlightsTabFragment
        }
    }
}