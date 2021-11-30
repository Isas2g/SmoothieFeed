package com.example.smoothiefeedapp.data.daos

import androidx.room.*
import com.example.smoothiefeedapp.data.enteties.db.UserEntity
import com.example.smoothiefeedapp.data.contracts.UserContract
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserEntity(userEntity: UserEntity)

    @Query("SELECT * FROM ${UserContract.TABLE_NAME}")
    fun getUserEntitiesList(): Flow<List<UserEntity?>>

    @Query("DELETE FROM ${UserContract.TABLE_NAME}")
    suspend fun deleteUserEntity()

    @Update
    suspend fun updateUserEntity(userEntity: UserEntity)
}