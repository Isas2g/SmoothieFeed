package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.repositories.NewsRepository

class LoadNewsListUseCase(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke() = newsRepository.loadNews()
}