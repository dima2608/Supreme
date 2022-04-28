package com.triare.supreme.ui.screens.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.triare.supreme.R
import com.triare.supreme.ui.adapters.NewsAdapter
import com.triare.supreme.ui.models.NewsViewModel

class NewsFragment : Fragment() {

    private val newsViewModel by viewModels<NewsViewModel>()
    private lateinit var newsAdaptor: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
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
        val newsRecycler = view?.findViewById<RecyclerView>(R.id.recycler_view_news)
        newsRecycler?.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            newsAdaptor = NewsAdapter(context)
            adapter = newsAdaptor
        }
    }

    private fun observeUpdates() {
        newsViewModel.newsLiveData.observe(viewLifecycleOwner) {
            val news = it ?: return@observe
            newsAdaptor.submitNewsList(news)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsFragment()
    }
}