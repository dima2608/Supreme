package com.triare.supreme.ui.dvo

import com.google.firebase.storage.StorageReference

data class CircuitDvo(
    val distance: String,
    val icon: StorageReference,
    val laps: String,
    val length: String,
    val record: String,
    val recordDriver: String,
    val title: String
)
