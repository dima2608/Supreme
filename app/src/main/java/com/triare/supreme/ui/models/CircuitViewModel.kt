package com.triare.supreme.ui.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentReference
import com.triare.supreme.data.repository.RacingRepository
import com.triare.supreme.ui.dvo.CircuitDvo

class CircuitViewModel: ViewModel() {

    private val racingRepo = RacingRepository()

    private val _circuitLiveData = MutableLiveData<CircuitDvo>()
    val circuitLiveData: LiveData<CircuitDvo> = _circuitLiveData

    fun observeCircuits(circuit: DocumentReference) {
        racingRepo.observeCircuit(circuit) { result ->
            if (result.isSuccess) {
                _circuitLiveData.value = result.getOrNull()
            }
        }
    }
}