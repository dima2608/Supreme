package com.triare.supreme.data.repository

import com.triare.supreme.data.remote.StandingsDataSource
import com.triare.supreme.ui.dvo.StandingsDvo

class StandingsRepository {

    private val standingsDataSource = StandingsDataSource()

    fun observeStandings(onResult: (Result<List<StandingsDvo>>) -> Unit){
        standingsDataSource.observeStandings(onResult)
    }
}