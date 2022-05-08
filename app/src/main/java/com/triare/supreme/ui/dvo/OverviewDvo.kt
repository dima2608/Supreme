package com.triare.supreme.ui.dvo

import com.google.firebase.storage.StorageReference

data class OverviewDvo(
    val fastestLap: FastestLapDvo? = null,
    val results: List<ResultDvo>? = null,
)

data class FastestLapDvo(
    val constructor: String? = null,
    val driver: String? = null,
    val icon: StorageReference? = null,
    val lap: String? = null,
    val time: String? = null
)

data class ResultDvo(
    val constructor: String? = null,
    val driver: String? = null,
    val icon: StorageReference? = null,
    val points: String? = null,
    val pos: Int? = null,
    val time: String? = null
)
