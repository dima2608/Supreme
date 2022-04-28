package com.triare.supreme.data.mapper

import com.google.firebase.storage.FirebaseStorage
import com.triare.supreme.data.models.NewsDto
import com.triare.supreme.ui.dvo.NewsDvo

class NewsMapper(private val newsDto: List<NewsDto>) {

    fun map(storage: FirebaseStorage): List<NewsDvo> {
        return newsDto.map {
            NewsDvo(
                it.title.orEmpty(),
                it.date.orEmpty(),
                storage.getReferenceFromUrl(it.img!!),
                it.link.orEmpty()
            )
        }
    }

}