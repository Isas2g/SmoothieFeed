package com.example.smoothiefeedapp.data.daos

import androidx.room.*
import com.example.smoothiefeedapp.data.enteties.db.NewsEntity
import com.example.smoothiefeedapp.data.contracts.NewsContract
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewsEntityList(newsEntityList: List<NewsEntity>)

    @Query("SELECT * FROM ${NewsContract.TABLE_NAME}")
    fun getNewsEntity(): Flow<List<NewsEntity>>

    @Query("DELETE FROM ${NewsContract.TABLE_NAME}")
    suspend fun deleteAllNewsEntity()
}