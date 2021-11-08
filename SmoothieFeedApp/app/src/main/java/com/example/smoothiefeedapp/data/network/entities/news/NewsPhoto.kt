package com.example.smoothiefeedapp.data.network.entities.news

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsPhoto(
    val id: String?,
    val sizes: List<NewsPhotoUrl>?
)