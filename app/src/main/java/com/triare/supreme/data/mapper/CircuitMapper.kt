package com.triare.supreme.data.mapper

import com.google.firebase.storage.FirebaseStorage
import com.triare.supreme.data.models.CircuitDto
import com.triare.supreme.ui.dvo.CircuitDvo

class CircuitMapper(private val circuitDto: CircuitDto?) {

    fun map(storage: FirebaseStorage): CircuitDvo {
        return CircuitDvo(
            circuitDto?.distance!!,
            storage.getReferenceFromUrl(circuitDto.icon!!),
            circuitDto.laps!!,
            circuitDto.length!!,
            circuitDto.record!!,
            "Lap record - ${circuitDto.recordDriver!!}",
            circuitDto.title!!,
        )
    }
}