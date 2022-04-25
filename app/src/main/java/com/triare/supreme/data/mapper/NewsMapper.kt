package com.triare.supreme.data.mapper

import com.triare.supreme.data.models.NewsDto
import com.triare.supreme.ui.dvo.NewsDvo

class NewsMapper(private val newsDto: List<NewsDto>) {

    fun map(): List<NewsDvo>{
        return newsDto.map {
            NewsDvo(
                it.title.orEmpty(),
                it.date.orEmpty(),
                it.imgLink.orEmpty(),
                it.link.orEmpty()
            )
        }
    }

}