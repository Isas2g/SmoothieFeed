package com.example.smoothiefeedapp.data.enteties.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.smoothiefeedapp.data.contracts.SFUserContract

@Entity(tableName = SFUserContract.TABLE_NAME)
data class SFUserEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = SFUserContract.Columns.USERNAME)
    val userName: String
)