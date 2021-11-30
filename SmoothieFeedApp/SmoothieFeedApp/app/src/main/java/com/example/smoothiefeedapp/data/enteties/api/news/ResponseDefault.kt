package com.example.smoothiefeedapp.data.enteties.api.news

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseDefault (
    val response: NewsResponse
)