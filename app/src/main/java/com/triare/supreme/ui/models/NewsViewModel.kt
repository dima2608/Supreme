package com.triare.supreme.ui.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.triare.supreme.data.models.NewsDto
import com.triare.supreme.data.repository.NewsRepository
import com.triare.supreme.ui.dvo.NewsDvo

class NewsViewModel: ViewModel() {

    private val newsRepository = NewsRepository()

    private val _newsLiveData = MutableLiveData<List<NewsDvo>>()
    val newsLiveData: LiveData<List<NewsDvo>> = _newsLiveData

    init {
        observeNews()
    }
    private fun observeNews(){
        newsRepository.observeNews{ result ->
            if (result.isSuccess) {
                _newsLiveData.value = result.getOrNull()
            }
        }
    }
}