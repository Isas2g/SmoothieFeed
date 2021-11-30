package com.example.smoothiefeedapp.domain.repositories

import kotlinx.coroutines.flow.Flow

interface DetoxRepository {
    suspend fun save(detox: Any)

    fun get(): Flow<Any?>

    suspend fun delete()
}