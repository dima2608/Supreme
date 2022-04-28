package com.triare.supreme.ui.dvo

import com.google.firebase.storage.StorageReference

data class RacingDvo(
    val circuitId: String,
    val round: String,
    val date: String,
    val country: String,
    val circuitName:String,
    val laps: String,
    val icon: StorageReference
)
