package com.example.smoothiefeedapp.domain.repositories

import com.example.smoothiefeedapp.data.enteties.api.SFToken
import kotlinx.coroutines.flow.Flow

interface SFTokenRepository {
    suspend fun saveSFToken(sFToken: SFToken)

    fun getSFToken(): Flow<String?>

    fun getSFRefreshToken(): Flow<String?>

    suspend fun deleteSFToken()
}