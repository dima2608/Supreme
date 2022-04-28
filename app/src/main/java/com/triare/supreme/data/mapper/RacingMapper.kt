package com.triare.supreme.data.mapper

import com.google.firebase.storage.FirebaseStorage
import com.triare.supreme.data.models.RaceDto
import com.triare.supreme.ui.dvo.RacingDvo

class RacingMapper(private val racingDto: List<RaceDto>) {

    fun map(storage: FirebaseStorage): List<RacingDvo> {
        return racingDto.map {
            RacingDvo(
                it.circuitId.orEmpty(),
                "round ${it.round}",
                "7.7.7777",
                it.country.orEmpty(),
                it.circuitName.orEmpty(),
                "laps ${it.laps}",
                storage.getReferenceFromUrl(it.icon!!)
            )
        }
    }
}