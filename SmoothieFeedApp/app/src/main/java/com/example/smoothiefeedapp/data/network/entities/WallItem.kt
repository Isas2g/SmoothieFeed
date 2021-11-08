package com.example.smoothiefeedapp.data.network.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WallItem (
    val id: Int,
    val attachments: List<Photo>
)