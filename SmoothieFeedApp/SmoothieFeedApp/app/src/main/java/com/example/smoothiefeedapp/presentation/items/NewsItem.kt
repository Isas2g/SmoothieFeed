package com.example.smoothiefeedapp.presentation.items

import com.example.smoothiefeedapp.domain.enteties.News

data class NewsItem(
    val news: News,
    var isExpended: Boolean = false
)