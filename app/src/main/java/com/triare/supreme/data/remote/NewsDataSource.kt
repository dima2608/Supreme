package com.triare.supreme.data.remote

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.triare.supreme.data.mapper.NewsMapper
import com.triare.supreme.data.models.NewsDto
import com.triare.supreme.ui.dvo.NewsDvo

class NewsDataSource {

    private val db = FirebaseFirestore.getInstance()
    private val cities = db.collection(NEWS_COLLECTION)

    fun observeCities(onResult: (Result<List<NewsDvo>>) -> Unit) {
        cities.addSnapshotListener { value, error ->
            if (error != null) {
                Log.w(TAG, "Listen failed.", error)
                onResult(Result.failure(error))
                return@addSnapshotListener
            }

            if (value != null) {
                try {
                    val news = value.toObjects(NewsDto::class.java)
                    Log.d("NewsImg", news[0].title.orEmpty())
                    onResult(Result.success(NewsMapper(news).map()))
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
        private const val NEWS_COLLECTION = "news"
        private const val TAG = "NewsDataSource"
    }

}