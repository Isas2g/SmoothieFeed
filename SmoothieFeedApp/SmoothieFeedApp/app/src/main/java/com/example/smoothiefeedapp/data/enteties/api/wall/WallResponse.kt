package com.example.smoothiefeedapp.data.enteties.api.wall

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WallResponse(
    val response: Wall
)