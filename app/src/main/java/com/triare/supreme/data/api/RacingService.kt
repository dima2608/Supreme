package com.triare.supreme.data.api

import com.triare.supreme.data.api.model.RaceResultDto
import com.triare.supreme.data.api.model.RacingDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RacingService {

    @GET("api/f1/current.json")
    suspend fun getCurrentRaces(
    ): Response<RacingDto>

    @GET("current")
    suspend fun getRaceResults(

    ):Response<List<RaceResultDto>>

}