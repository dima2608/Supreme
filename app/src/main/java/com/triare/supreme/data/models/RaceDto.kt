package com.triare.supreme.data.models

import com.google.firebase.Timestamp

data class RaceDto(
    val circuitId: String? = null,
    val icon: String? = null,
    val round: Int? = null,
    val date: Timestamp? = null,
    val circuitName: String? = null,
    val country: String? = null,
    val laps: String? = null
)
