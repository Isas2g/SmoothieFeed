package com.example.smoothiefeedapp.data.enteties.api.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse (
    val response: User?
)