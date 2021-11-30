package com.example.smoothiefeedapp.domain.repositories

import com.example.smoothiefeedapp.domain.enteties.NewSFUser
import com.example.smoothiefeedapp.domain.enteties.SFUser
import kotlinx.coroutines.flow.Flow

interface SFUserRepository {
    suspend fun createNew(newSFUser: NewSFUser)

    suspend fun auth(userName: String, password: String)

    suspend fun get(): Flow<SFUser?>

    suspend fun delete()
}