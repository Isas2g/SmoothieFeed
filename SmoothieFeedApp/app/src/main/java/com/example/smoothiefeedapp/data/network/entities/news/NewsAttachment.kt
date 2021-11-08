package com.example.smoothiefeedapp.data.network.entities.news

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsAttachment (
    val type: String?,
    val photo: NewsPhoto?
)