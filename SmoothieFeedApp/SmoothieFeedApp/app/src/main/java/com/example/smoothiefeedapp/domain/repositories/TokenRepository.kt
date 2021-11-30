package com.example.smoothiefeedapp.domain.repositories

import kotlinx.coroutines.flow.Flow

interface TokenRepository {
    suspend fun saveToken(stringWithToken: String, socialNetworkName: String)

    fun getToken(socialNetworkName: String): Flow<String?>
}