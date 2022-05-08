package com.triare.supreme.data.mapper

import com.google.firebase.storage.FirebaseStorage
import com.triare.supreme.data.models.OverviewDto
import com.triare.supreme.data.models.Result
import com.triare.supreme.ui.dvo.FastestLapDvo
import com.triare.supreme.ui.dvo.OverviewDvo
import com.triare.supreme.ui.dvo.ResultDvo

class OverviewMapper(overviewDto: OverviewDto?) {

    private val result: List<Result>? = overviewDto?.redults
    private val fastestLap = overviewDto?.fastestLap

    fun map(storage: FirebaseStorage): OverviewDvo {
        return OverviewDvo(
            FastestLapDvo(
                fastestLap?.constructor,
                fastestLap?.driver,
                storage.getReferenceFromUrl(fastestLap?.icon!!),
                "Lap ${fastestLap.lap}",
                fastestLap.time
            ),
            mapResult(storage)
        )
    }

    private fun mapResult(storage: FirebaseStorage): List<ResultDvo>? {
        return result?.map {
            ResultDvo(
                it.constructor,
                it.driver,
                storage.getReferenceFromUrl(it.icon!!),
                "${it.points} pts",
                it.pos,
                it.time
            )
        }
    }
}