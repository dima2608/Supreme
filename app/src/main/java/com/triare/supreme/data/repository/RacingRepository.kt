package com.triare.supreme.data.repository

import com.google.firebase.firestore.DocumentReference
import com.triare.supreme.data.api.Rest
import com.triare.supreme.data.api.model.StandingsApiDto
import com.triare.supreme.data.models.OverviewDto
import com.triare.supreme.data.remote.NewsDataSource
import com.triare.supreme.data.remote.RacingDataSource
import com.triare.supreme.ui.dvo.CircuitDvo
import com.triare.supreme.ui.dvo.NewsDvo
import com.triare.supreme.ui.dvo.OverviewDvo
import com.triare.supreme.ui.dvo.RacingDvo
import retrofit2.Response

class RacingRepository {

    private val raceDataSource = RacingDataSource()
    private val newsDataSource = NewsDataSource()

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

    fun observeCircuit(circuitRef: DocumentReference, onResult: (Result<CircuitDvo>) -> Unit) {
        raceDataSource.observeCircuit(onResult, circuitRef)
    }

    fun observeMediaNews(circuitId: String, onResult: (Result<List<NewsDvo>>) -> Unit) {
        newsDataSource.observeMediaNews(onResult, circuitId)
    }

    fun observeOverview(overviewRef: DocumentReference, onResult: (Result<OverviewDvo>) -> Unit) {
        raceDataSource.observeOverview(onResult, overviewRef)
    }

}
