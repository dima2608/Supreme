package com.triare.supreme.data.models

data class OverviewDto(
    val circuitId: String? = null,
    val fastestLap: FastestLap? = null,
    val redults: List<Result>? = null,
    val round: Int? = null
)

data class FastestLap(
    val constructor: String? = null,
    val driver: String? = null,
    val icon: String? = null,
    val lap: String? = null,
    val time: String? = null
)

data class Result(
    val constructor: String? = null,
    val driver: String? = null,
    val icon: String? = null,
    val points: String? = null,
    val pos: Int? = null,
    val time: String? = null
)