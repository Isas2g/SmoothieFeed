package com.example.smoothiefeedapp.data.converters

import androidx.room.TypeConverter

class PhotoUrlsConverter {
    @TypeConverter
    fun fromPhotoUrls(photoUrlsList: List<String>) =
        photoUrlsList.joinToString(",")

    @TypeConverter
    fun toPhotoUrls(photoUrlsString: String) =
        photoUrlsString.split(",")
}