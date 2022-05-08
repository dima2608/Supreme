package com.triare.supreme.utils

import com.triare.supreme.R

enum class Medal {
    FiRST,
    SECOND,
    THIRD;

    val medal: Int
        get() = when (this) {
            FiRST -> R.drawable.ic_icon_first
            SECOND -> R.drawable.ic_icon_second
            THIRD -> R.drawable.ic_icon_third
        }

    companion object {
        fun getMedal(pos: Int): Medal {
            return when (pos) {
                1 -> FiRST
                2 -> SECOND
                else -> THIRD
            }
        }
    }
}
