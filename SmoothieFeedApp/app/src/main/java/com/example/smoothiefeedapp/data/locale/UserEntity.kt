package com.example.smoothiefeedapp.data.locale

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserContract.TABLE_NAME)
data class UserEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = UserContract.Columns.ID)
    val id: String,

//    @ColumnInfo(name = UserContract.Columns.USERNAME)
//    val username: String,

    @ColumnInfo(name = UserContract.Columns.FIRST_NAME)
    val firstName: String,

    @ColumnInfo(name = UserContract.Columns.LAST_NAME)
    val lastName: String
)