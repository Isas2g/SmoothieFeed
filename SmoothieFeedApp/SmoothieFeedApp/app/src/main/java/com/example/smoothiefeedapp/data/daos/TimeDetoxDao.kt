package com.example.smoothiefeedapp.data.daos

import androidx.room.*
import com.example.smoothiefeedapp.data.enteties.db.TimeDetoxEntity
import com.example.smoothiefeedapp.data.contracts.TimeDetoxContract
import kotlinx.coroutines.flow.Flow

@Dao
interface TimeDetoxDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTimeDetoxEntity(timeDetoxEntity: TimeDetoxEntity)

    @Query("SELECT * FROM ${TimeDetoxContract.TABLE_NAME}")
    fun getTimeDetoxEntity(): Flow<TimeDetoxEntity?>

    @Query("DELETE FROM ${TimeDetoxContract.TABLE_NAME}")
    suspend fun deleteTimeDetoxEntity()

    @Update
    suspend fun updateTimeDetoxEntity(timeDetoxEntity: TimeDetoxEntity)
}