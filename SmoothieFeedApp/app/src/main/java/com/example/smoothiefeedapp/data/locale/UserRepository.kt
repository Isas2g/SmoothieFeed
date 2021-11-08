package com.example.smoothiefeedapp.data.locale

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

class UserRepository {
    private val userDao = Database.appDatabase.getUserDao()

//    suspend fun addUserEntity(userEntity: UserEntity)
//
//    fun getUserEntitiesList(): Flow<List<UserEntity>>
//
//    suspend fun deleteUserEntity(userEntity: UserEntity)
//
//    suspend fun updateUserEntity(userEntity: UserEntity)
}