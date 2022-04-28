package com.triare.supreme.data.repository

import com.triare.supreme.data.api.Rest
import com.triare.supreme.data.api.model.RacingDto
import com.triare.supreme.data.api.model.StandingsApiDto
import com.triare.supreme.data.models.StandingsDto
import com.triare.supreme.data.remote.RacingDataSource
import com.triare.supreme.ui.dvo.NewsDvo
import com.triare.supreme.ui.dvo.RacingDvo
import retrofit2.Response

class RacingRepository {

    private val raceDataSource = RacingDataSource()

    suspend fun getRace(): Response<StandingsApiDto> {
        return Rest.apiService.getStandings()
    }

    fun addRaces(data: StandingsApiDto) {
        raceDataSource.addStandings(data)
    }

    fun observeUpcomingRaces(onResult: (Result<List<RacingDvo>>) -> Unit) {
        raceDataSource.observeUpcomingRaces(onResult)
    }

    fun observePreviousRaces(onResult: (Result<List<RacingDvo>>) -> Unit) {
        raceDataSource.observePreviousRaces(onResult)
    }

}
