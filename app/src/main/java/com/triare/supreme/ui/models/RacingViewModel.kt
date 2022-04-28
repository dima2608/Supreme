package com.triare.supreme.ui.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triare.supreme.data.api.model.RacingDto
import com.triare.supreme.data.repository.RacingRepository
import com.triare.supreme.ui.dvo.RacingDvo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RacingViewModel : ViewModel() {

    private val racingRepo = RacingRepository()


    private val _raceUpcomingLiveData = MutableLiveData<List<RacingDvo>>()
    val raceUpcomingLiveData: LiveData<List<RacingDvo>> = _raceUpcomingLiveData

    private val _racePreviousLiveData = MutableLiveData<List<RacingDvo>>()
    val racePreviousLiveData: LiveData<List<RacingDvo>> = _racePreviousLiveData

    private fun getRaces() {
        viewModelScope.launch(Dispatchers.Main) {
            val currentRaces = racingRepo.getRace()
            if (currentRaces.isSuccessful) {
                currentRaces.body()?.let { addRaces(it) }
            }

        }
    }

    private fun addRaces(data: RacingDto) {
        racingRepo.addRaces(data)
    }

    fun observeUpcomingRaces() {
        racingRepo.observeUpcomingRaces { result ->
            if (result.isSuccess) {
                _raceUpcomingLiveData.value = result.getOrNull()
            }
        }
    }

    fun observePreviousRaces() {
        racingRepo.observePreviousRaces { result ->
            if (result.isSuccess) {
                _racePreviousLiveData.value = result.getOrNull()
            }
        }
    }
}