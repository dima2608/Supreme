package com.triare.supreme.data.remote

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.triare.supreme.data.mapper.StandingsMapper
import com.triare.supreme.data.models.StandingsDto
import com.triare.supreme.ui.dvo.StandingsDvo

class StandingsDataSource {
    private val db = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private val standings = db.collection(STANDINGS_COLLECTION)

    fun observeStandings(onResult: (Result<List<StandingsDvo>>) -> Unit) {
        standings.orderBy("position").addSnapshotListener{value, error ->
            if (error != null) {
                Log.w(TAG, "Listen failed.", error)
                onResult(Result.failure(error))
                return@addSnapshotListener
            }

            if (value != null) {
                try {
                    val standings = value.toObjects(StandingsDto::class.java)
                    onResult(Result.success(StandingsMapper(standings).map(storage)))
                    Log.d(TAG, standings.toString())
                } catch (e: Exception) {
                    e.printStackTrace()
                    onResult(Result.failure(e))
                }
            } else {
                Log.d(TAG, "Current data: null")
            }
        }
    }

    companion object {
        const val STANDINGS_COLLECTION = "standings"
        const val TAG = "StandingsDataSource"
    }
}
