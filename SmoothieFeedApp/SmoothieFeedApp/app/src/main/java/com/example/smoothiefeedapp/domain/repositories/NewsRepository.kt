package com.example.smoothiefeedapp.domain.repositories

import com.example.smoothiefeedapp.domain.enteties.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(): Flow<List<News>>

    suspend fun loadNews()

    suspend fun deleteAllNews()
}