package com.example.smoothiefeedapp.data.enteties.api.news

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsPhotoSize(
    val url: String?
)