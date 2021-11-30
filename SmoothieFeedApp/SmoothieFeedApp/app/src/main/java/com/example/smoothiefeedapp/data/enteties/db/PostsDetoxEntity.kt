package com.example.smoothiefeedapp.data.enteties.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.smoothiefeedapp.data.contracts.PostsDetoxContract

@Entity(tableName = PostsDetoxContract.TABLE_NAME)
data class PostsDetoxEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = PostsDetoxContract.Columns.POSTS)
    val posts: Int?
)