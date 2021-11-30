package com.example.smoothiefeedapp.data.enteties.api.wall

import com.example.smoothiefeedapp.data.enteties.api.Photo
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WallItem (
    val id: Int,
    val attachments: List<Photo>
)