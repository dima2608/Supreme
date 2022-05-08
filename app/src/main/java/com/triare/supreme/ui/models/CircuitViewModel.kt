package com.triare.supreme.ui.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentReference
import com.triare.supreme.data.models.OverviewDto
import com.triare.supreme.data.repository.RacingRepository
import com.triare.supreme.ui.dvo.CircuitDvo
import com.triare.supreme.ui.dvo.NewsDvo
import com.triare.supreme.ui.dvo.OverviewDvo

class CircuitViewModel : ViewModel() {

    private val racingRepo = RacingRepository()

    private val _circuitLiveData = MutableLiveData<CircuitDvo>()
    val circuitLiveData: LiveData<CircuitDvo> = _circuitLiveData

    private val _mediaNewsLiveData = MutableLiveData<List<NewsDvo>>()
    val mediaNewsLiveData: LiveData<List<NewsDvo>> = _mediaNewsLiveData

    private val _overviewLiveData = MutableLiveData<OverviewDvo>()
    val overviewLiveData: LiveData<OverviewDvo> = _overviewLiveData

    fun observeCircuits(circuit: DocumentReference) {
        racingRepo.observeCircuit(circuit) { result ->
            if (result.isSuccess) {
                _circuitLiveData.value = result.getOrNull()
            }
        }
    }

    fun observeMediaNews(circuitId: String) {
        racingRepo.observeMediaNews(circuitId) { result ->
            if (result.isSuccess) {
                _mediaNewsLiveData.value = result.getOrNull()
            }
        }
    }

    fun observeOverview(overviewRef: DocumentReference) {
        racingRepo.observeOverview(overviewRef) { result ->
            if (result.isSuccess) {
                _overviewLiveData.value = result.getOrNull()
            }
        }
    }
}