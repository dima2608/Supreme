package com.triare.supreme.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    private const val DATE_TIME_PATTERN = "dd, MMM, yyyy"

    @SuppressLint("SimpleDateFormat")
    fun parseDate(d: Date): String {
        val sdf = SimpleDateFormat(DATE_TIME_PATTERN)
        return sdf.format(d)
    }
}