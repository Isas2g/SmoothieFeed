package com.example.smoothiefeedapp.data.enteties.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Photo(
    val id: Int,
    @Json(name = "photo_1280") val photoUrl: String
)
