package com.example.smoothiefeedapp.data.daos

import androidx.room.*
import com.example.smoothiefeedapp.data.enteties.db.DetoxEntity
import com.example.smoothiefeedapp.data.contracts.DetoxContract

@Dao
interface DetoxDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDetoxEntity(detoxEntity: DetoxEntity)

    @Query("SELECT * FROM ${DetoxContract.TABLE_NAME}")
    suspend fun getDetoxEntity(): DetoxEntity

    @Delete
    suspend fun deleteDetoxEntity(detoxEntity: DetoxEntity)

    @Update
    suspend fun updateDetoxEntity(detoxEntity: DetoxEntity)
}