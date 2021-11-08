package com.example.smoothiefeedapp.data.network.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "id") val id: Int,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String
)