package com.example.smoothiefeedapp.data.daos

import androidx.room.*
import com.example.smoothiefeedapp.data.enteties.db.SFUserEntity
import com.example.smoothiefeedapp.data.contracts.SFUserContract
import kotlinx.coroutines.flow.Flow

@Dao
interface SFUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSFUserEntity(sfUserEntity: SFUserEntity)

    @Query("SELECT * FROM ${SFUserContract.TABLE_NAME}")
    fun getSFUserEntity(): Flow<SFUserEntity?>

    @Query("DELETE FROM ${SFUserContract.TABLE_NAME}")
    suspend fun deleteSFUserEntity()
}