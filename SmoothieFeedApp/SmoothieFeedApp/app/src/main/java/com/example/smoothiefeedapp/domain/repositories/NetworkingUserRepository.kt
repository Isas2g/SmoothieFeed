package com.example.smoothiefeedapp.domain.repositories

import com.example.smoothiefeedapp.data.enteties.api.user.User
import kotlinx.coroutines.flow.Flow

interface NetworkingUserRepository {
    fun get(socialNetworkingName: String): Flow<List<User>>

    suspend fun load(socialNetworkingName: String)
}