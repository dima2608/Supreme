package com.triare.supreme.ui.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.triare.supreme.data.repository.StandingsRepository
import com.triare.supreme.ui.dvo.StandingsDvo

class StandingsViewModel : ViewModel() {

    private val standingsRepo = StandingsRepository()

    private val _standingsLiveData = MutableLiveData<List<StandingsDvo>>()
    val standingsLiveData: LiveData<List<StandingsDvo>> = _standingsLiveData

    fun observeStandings() {
        standingsRepo.observeStandings { result ->
            if (result.isSuccess) {
                _standingsLiveData.value = result.getOrNull()
            }
        }
    }
}