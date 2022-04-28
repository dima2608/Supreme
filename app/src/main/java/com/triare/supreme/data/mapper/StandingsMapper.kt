package com.triare.supreme.data.mapper


import com.google.firebase.storage.FirebaseStorage
import com.triare.supreme.data.models.StandingsDto
import com.triare.supreme.ui.dvo.StandingsDvo

class StandingsMapper(private val standingsDto: List<StandingsDto>) {

    fun map(storage: FirebaseStorage): List<StandingsDvo> {
        return standingsDto.map {
            StandingsDvo(
                it.driverName.orEmpty(),
                it.driverFamilyName.orEmpty(),
                it.permanentNumber.orEmpty(),
                storage.getReferenceFromUrl(it.icon!!)
            )
        }
    }
}