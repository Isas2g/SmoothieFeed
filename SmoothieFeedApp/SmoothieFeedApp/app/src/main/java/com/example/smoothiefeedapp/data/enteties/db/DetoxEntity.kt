package com.example.smoothiefeedapp.data.enteties.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.smoothiefeedapp.data.contracts.DetoxContract

@Entity(tableName = DetoxContract.TABLE_NAME)
data class DetoxEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = DetoxContract.Columns.POST)
    val post: Int,

    @ColumnInfo(name = DetoxContract.Columns.TIME)
    val time: Long
)