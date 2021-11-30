package com.example.smoothiefeedapp.data.daos

import androidx.room.*
import com.example.smoothiefeedapp.data.enteties.db.PostsDetoxEntity
import com.example.smoothiefeedapp.data.contracts.PostsDetoxContract
import kotlinx.coroutines.flow.Flow

@Dao
interface PostsDetoxDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPostsDetoxEntity(postsDetoxEntity: PostsDetoxEntity)

    @Query("SELECT * FROM ${PostsDetoxContract.TABLE_NAME}")
    fun getPostsDetoxEntity(): Flow<PostsDetoxEntity?>

    @Query("DELETE FROM ${PostsDetoxContract.TABLE_NAME}")
    suspend fun deletePostsDetoxEntity()

    @Update
    suspend fun updatePostsUserEntity(postsDetoxEntity: PostsDetoxEntity)
}