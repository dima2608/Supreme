package com.triare.supreme.data.api.model

import com.google.gson.annotations.SerializedName

data class RaceResultDto(

	@field:SerializedName("MRData")
	val mRData: RaceResultMRData
)

data class RaceResultTime(

	@field:SerializedName("time")
	val time: String,

	@field:SerializedName("millis")
	val millis: String
)

data class RaceResultConstructor(

	@field:SerializedName("nationality")
	val nationality: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("constructorId")
	val constructorId: String,

	@field:SerializedName("url")
	val url: String
)

data class RaceResultRacesItem(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("round")
	val round: String,

	@field:SerializedName("Results")
	val results: List<RaceResultResultsItem>,

	@field:SerializedName("season")
	val season: String,

	@field:SerializedName("raceName")
	val raceName: String,

	@field:SerializedName("Circuit")
	val circuit: RaceResultCircuit,

	@field:SerializedName("time")
	val time: String,

	@field:SerializedName("url")
	val url: String
)

data class RaceResultMRData(

	@field:SerializedName("RaceTable")
	val raceTable: RaceResultRaceTable,

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
)

data class RaceResultResultsItem(

	@field:SerializedName("number")
	val number: String,

	@field:SerializedName("positionText")
	val positionText: String,

	@field:SerializedName("Constructor")
	val constructor: RaceResultConstructor,

	@field:SerializedName("grid")
	val grid: String,

	@field:SerializedName("Driver")
	val driver: RaceResultDriver,

	@field:SerializedName("laps")
	val laps: String,

	@field:SerializedName("position")
	val position: String,

	@field:SerializedName("points")
	val points: String,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("FastestLap")
	val fastestLap: RaceResultFastestLap,

	@field:SerializedName("Time")
	val time: RaceResultTime
)

data class RaceResultFastestLap(

	@field:SerializedName("AverageSpeed")
	val averageSpeed: RaceResultAverageSpeed,

	@field:SerializedName("rank")
	val rank: String,

	@field:SerializedName("lap")
	val lap: String,

	@field:SerializedName("Time")
	val time: RaceResultTime
)

data class RaceResultCircuit(

	@field:SerializedName("circuitId")
	val circuitId: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("circuitName")
	val circuitName: String,

	@field:SerializedName("Location")
	val location: RaceResultLocation
)

data class RaceResultLocation(

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("locality")
	val locality: String,

	@field:SerializedName("lat")
	val lat: String,

	@field:SerializedName("long")
	val jsonMemberLong: String
)

data class RaceResultAverageSpeed(

	@field:SerializedName("units")
	val units: String,

	@field:SerializedName("speed")
	val speed: String
)

data class RaceResultRaceTable(

	@field:SerializedName("Races")
	val races: List<RaceResultRacesItem>,

	@field:SerializedName("round")
	val round: String,

	@field:SerializedName("season")
	val season: String
)

data class RaceResultDriver(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("driverId")
	val driverId: String,

	@field:SerializedName("permanentNumber")
	val permanentNumber: String,

	@field:SerializedName("nationality")
	val nationality: String,

	@field:SerializedName("givenName")
	val givenName: String,

	@field:SerializedName("familyName")
	val familyName: String,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String,

	@field:SerializedName("url")
	val url: String
)
