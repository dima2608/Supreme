package com.triare.supreme.data.remote

import android.util.Log
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.triare.supreme.data.api.model.StandingsApiDto
import com.triare.supreme.data.mapper.CircuitMapper
import com.triare.supreme.data.mapper.RacingMapper
import com.triare.supreme.data.models.CircuitDto
import com.triare.supreme.data.models.OverviewDto
import com.triare.supreme.data.models.RaceDto
import com.triare.supreme.ui.dvo.CircuitDvo
import com.triare.supreme.ui.dvo.RacingDvo
import java.util.*

class RacingDataSource {

    private val date: Timestamp = Timestamp(Calendar.getInstance().time)
    private val db = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private val race = db.collection(RACING_COLLECTION)


    fun addStandings(data: StandingsApiDto) {
    }

    fun observeUpcomingRaces(onResult: (Result<List<RacingDvo>>) -> Unit) {
        race.whereGreaterThan("date", date).addSnapshotListener { value, error ->
            if (error != null) {
                Log.w(TAG, "Listen failed.", error)
                onResult(Result.failure(error))
                return@addSnapshotListener
            }

            if (value != null) {
                try {
                    val races = value.toObjects(RaceDto::class.java)
                    onResult(Result.success(RacingMapper(races).map(storage)))
                } catch (e: Exception) {
                    e.printStackTrace()
                    onResult(Result.failure(e))
                }
            } else {
                Log.d(TAG, "Current data: null")
            }
        }
    }

    fun observePreviousRaces(onResult: (Result<List<RacingDvo>>) -> Unit) {
        race.whereLessThan("date", date).addSnapshotListener { value, error ->
            if (error != null) {
                Log.w(TAG, "Listen failed.", error)
                onResult(Result.failure(error))
                return@addSnapshotListener
            }

            if (value != null) {
                try {
                    val races = value.toObjects(RaceDto::class.java)
                    onResult(Result.success(RacingMapper(races).map(storage)))
                } catch (e: Exception) {
                    e.printStackTrace()
                    onResult(Result.failure(e))
                }
            } else {
                Log.d(TAG, "Current data: null")
            }
        }
    }

    fun observeCircuit(onResult: (Result<CircuitDvo>) -> Unit, circuitRef: DocumentReference) {
        db.document(circuitRef.path).get().addOnSuccessListener { value ->
            val circuit = value.toObject(CircuitDto::class.java)
            onResult(Result.success(CircuitMapper(circuit).map(storage)))
        }
    }

    fun observeOverview(onResult: (Result<CircuitDvo>) -> Unit, overviewRef: DocumentReference) {
        db.document(overviewRef.path).get().addOnSuccessListener { value ->
            val circuit = value.toObject(OverviewDto::class.java)
            onResult(Result.success(CircuitMapper(circuit).map(storage)))
        }
    }

    companion object {
        private const val CIRCUIT_COLLECTION = "circuit"
        private const val RACING_COLLECTION = "racing"
        private const val TAG = "RacingDataSource"
    }
}