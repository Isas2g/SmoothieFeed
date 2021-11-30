package com.example.smoothiefeedapp.data.enteties.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.smoothiefeedapp.data.contracts.UserContract

@Entity(tableName = UserContract.TABLE_NAME)
data class UserEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = UserContract.Columns.ID)
    val id: Int,

//    @ColumnInfo(name = UserContract.Columns.USERNAME)
//    val username: String,

    @ColumnInfo(name = UserContract.Columns.FIRST_NAME)
    val firstName: String,

    @ColumnInfo(name = UserContract.Columns.LAST_NAME)
    val lastName: String
)