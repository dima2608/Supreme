package com.triare.supreme.ui.screens.racing.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.triare.supreme.R
import com.triare.supreme.ui.adapters.MediaNewsAdapter
import com.triare.supreme.ui.adapters.NewsAdapter
import com.triare.supreme.ui.dvo.RacingDvo
import com.triare.supreme.ui.models.CircuitViewModel

class MediaTabFragment : Fragment() {

    private val circuitViewModel by viewModels<CircuitViewModel>()
    private var dataRacing: RacingDvo? = null
    private lateinit var newsAdaptor: MediaNewsAdapter

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

        observeUpdates()
        initUi()
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
        initVideoRecycler()
    }

    private fun observeUpdates() {
        dataRacing?.let { circuitViewModel.observeMediaNews(it.circuitId) }
        circuitViewModel.mediaNewsLiveData.observe(viewLifecycleOwner) {
            val news = it ?: return@observe
            newsAdaptor.submitNewsList(news)
        }
    }

    private fun initNewsRecycler() {
        val newsRecycler = view?.findViewById<RecyclerView>(R.id.recycler_view_media_news)
        newsRecycler?.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            newsAdaptor = MediaNewsAdapter(context)
            adapter = newsAdaptor
        }
    }

    private fun initVideoRecycler() {

    }

    companion object {
        private const val KEY_DATA_CIRCUIT_ARGS = "MediaRef"
        fun newInstance(dataRacing: RacingDvo): MediaTabFragment {
            val args = bundleOf(KEY_DATA_CIRCUIT_ARGS to dataRacing)

            val mediaTabFragment = MediaTabFragment()
            mediaTabFragment.arguments = args

            return mediaTabFragment
        }
    }
}