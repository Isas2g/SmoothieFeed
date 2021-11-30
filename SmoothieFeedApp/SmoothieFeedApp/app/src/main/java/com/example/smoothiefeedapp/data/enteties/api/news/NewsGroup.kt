package com.example.smoothiefeedapp.data.enteties.api.news

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsGroup(
    val id: Int?,
    val name: String?,
    @Json(name = "photo_200") val photoUrl: String?
)