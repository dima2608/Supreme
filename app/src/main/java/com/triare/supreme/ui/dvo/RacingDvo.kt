package com.triare.supreme.ui.dvo

import android.os.Parcelable
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.storage.StorageReference
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class RacingDvo(
    val circuit: @RawValue DocumentReference?,
    val circuitId: String,
    val round: String,
    val date: String,
    val highlights: @RawValue DocumentReference?,
    val country: String,
    val circuitName: String,
    val laps: String,
    val icon: @RawValue StorageReference,
    val media: @RawValue DocumentReference?,
    val overview: @RawValue DocumentReference?
) : Parcelable
