package com.example.smoothiefeedapp.data.enteties.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SFToken(
    val token: String,
    val refresh: String
)