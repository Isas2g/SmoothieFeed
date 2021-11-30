package com.example.smoothiefeedapp.data.enteties.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.smoothiefeedapp.data.converters.PhotoUrlsConverter
import com.example.smoothiefeedapp.data.contracts.NewsContract

@Entity(tableName = NewsContract.TABLE_NAME)
@TypeConverters(PhotoUrlsConverter::class)
data class NewsEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = NewsContract.Columns.ID)
    val id: Int,

    @ColumnInfo(name = NewsContract.Columns.TEXT)
    val text: String,

    @ColumnInfo(name = NewsContract.Columns.PHOTO_URLS)
    val photoUrls: List<String>,

    @ColumnInfo(name = NewsContract.Columns.PUBLIC_NAME)
    val publicName: String,

    @ColumnInfo(name = NewsContract.Columns.PUBLIC_PHOTO_URL)
    val publicPhotoUrl: String,
)