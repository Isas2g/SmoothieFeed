package com.example.smoothiefeedapp.domain.enteties

data class News(
    val id: Int,
    val text: String,
    val photoUrls: List<String>,
    val publicName: String,
    val publicPhotoUrl: String
)