package com.example.smoothiefeedapp.data.network.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wall(
    val count: Int,
    val items: List<WallItem>
)