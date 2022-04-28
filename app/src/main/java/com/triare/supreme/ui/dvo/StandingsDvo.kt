package com.triare.supreme.ui.dvo

import com.google.firebase.storage.StorageReference

data class StandingsDvo(
    val driverName: String,
    val driverFamilyName: String,
    val permanentNumber: String,
    val icon: StorageReference
)