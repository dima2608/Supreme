package com.triare.supreme.ui.dvo

import com.google.firebase.storage.StorageReference

data class NewsDvo(
    val title: String,
    val date: String,
    val imgLink: StorageReference,
    val link: String
)