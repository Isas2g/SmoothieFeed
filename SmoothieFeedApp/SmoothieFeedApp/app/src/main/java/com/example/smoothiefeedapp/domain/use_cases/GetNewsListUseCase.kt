package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.repositories.NewsRepository
import com.example.smoothiefeedapp.domain.enteties.News
import kotlinx.coroutines.flow.Flow

class GetNewsListUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke() = newsRepository.getNews()
}