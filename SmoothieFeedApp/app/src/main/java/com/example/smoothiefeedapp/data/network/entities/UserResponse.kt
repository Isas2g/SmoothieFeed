package com.example.smoothiefeedapp.data.network.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse (
    val response: User?
)