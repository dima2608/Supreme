package com.triare.supreme.data.models

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference

data class RaceDto(
    val circuit: DocumentReference? = null,
    val circuitId: String? = null,
    val icon: String? = null,
    val round: Int? = null,
    val date: Timestamp? = null,
    val highlights: DocumentReference? = null,
    val circuitName: String? = null,
    val country: String? = null,
    val laps: String? = null,
    val media: DocumentReference? = null,
    val overview: DocumentReference? = null
)
