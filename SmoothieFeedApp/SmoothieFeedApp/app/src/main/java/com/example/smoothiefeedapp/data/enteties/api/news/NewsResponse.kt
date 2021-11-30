package com.example.smoothiefeedapp.data.enteties.api.news

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse (
    val items: List<NewsItem>?,
    val groups: List<NewsGroup>?,
    @Json(name = "next_from")val nextFrom: String?
)