package com.example.smoothiefeedapp.data.enteties.api.news

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsItem (
    @Json(name = "source_id")val sourceId: Int?,
    @Json(name = "post_type")val postType: String?,
    val text: String?,
    val attachments: List<NewsAttachment>?
)