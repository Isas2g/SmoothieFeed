package com.example.smoothiefeedapp.data.enteties.api.news

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsPhoto(
    val id: String?,
    val sizes: List<NewsPhotoSize>?
)