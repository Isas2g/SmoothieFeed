package com.example.smoothiefeedapp.data.enteties.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.smoothiefeedapp.data.contracts.TimeDetoxContract

@Entity(tableName = TimeDetoxContract.TABLE_NAME)
data class TimeDetoxEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = TimeDetoxContract.Columns.TIME)
    val time: Long?
)