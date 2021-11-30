package com.example.smoothiefeedapp.data.enteties.api.wall

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wall(
    val count: Int,
    val items: List<WallItem>
)