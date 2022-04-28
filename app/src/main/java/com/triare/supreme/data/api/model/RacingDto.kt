package com.triare.supreme.data.api.model

import com.google.gson.annotations.SerializedName


data class RacingDto(

    @field:SerializedName("MRData")
    val mRData: RacingMRData
) : java.io.Serializable

data class RacingFirstPractice(

    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("time")
    val time: String
) : java.io.Serializable

data class RacingItem(

    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("round")
    val round: String,

    @field:SerializedName("FirstPractice")
    val firstPractice: RacingFirstPractice,

    @field:SerializedName("ThirdPractice")
    val thirdPractice: RacingThirdPractice,

    @field:SerializedName("season")
    val season: String,

    @field:SerializedName("raceName")
    val raceName: String,

    @field:SerializedName("Circuit")
    val circuit: RacingCircuit,

    @field:SerializedName("time")
    val time: String,

    @field:SerializedName("SecondPractice")
    val secondPractice: RacingSecondPractice,

    @field:SerializedName("Qualifying")
    val qualifying: RacingQualifying,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("Sprint")
    val sprint: RacingSprint
) : java.io.Serializable

data class RacingQualifying(

    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("time")
    val time: String
) : java.io.Serializable

data class RacingThirdPractice(

    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("time")
    val time: String
) : java.io.Serializable

data class RacingLocation(

    @field:SerializedName("country")
    val country: String,

    @field:SerializedName("locality")
    val locality: String,

    @field:SerializedName("lat")
    val lat: String,

    @field:SerializedName("long")
    val long: String
) : java.io.Serializable

data class RacingCircuit(

    @field:SerializedName("circuitId")
    val circuitId: String,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("circuitName")
    val circuitName: String,

    @field:SerializedName("Location")
    val Location: RacingLocation
) : java.io.Serializable

data class RacingTable(

    @field:SerializedName("Races")
    val races: List<RacingItem>,

    @field:SerializedName("season")
    val season: String
) : java.io.Serializable

data class RacingSprint(

    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("time")
    val time: String
) : java.io.Serializable

data class RacingSecondPractice(

    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("time")
    val time: String
) : java.io.Serializable

data class RacingMRData(

    @field:SerializedName("RaceTable")
    val raceTable: RacingTable,

    @field:SerializedName("xmlns")
    val xmlns: String,

    @field:SerializedName("total")
    val total: String,

    @field:SerializedName("offset")
    val offset: String,

    @field:SerializedName("series")
    val series: String,

    @field:SerializedName("limit")
    val limit: String,

    @field:SerializedName("url")
    val url: String
) : java.io.Serializable
