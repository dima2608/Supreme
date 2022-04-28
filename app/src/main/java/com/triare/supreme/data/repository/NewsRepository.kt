package com.triare.supreme.data.repository

import com.triare.supreme.data.remote.NewsDataSource
import com.triare.supreme.ui.dvo.NewsDvo

class NewsRepository {

    private val newsDataSource = NewsDataSource()

    fun observeNews(onResult: (Result<List<NewsDvo>>) -> Unit) {
        newsDataSource.observeCities(onResult)
    }

}