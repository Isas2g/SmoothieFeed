package com.example.smoothiefeedapp.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.smoothiefeedapp.data.locale.AppDatabase.Companion.DB_VERSION

@Database(
    entities = [
        UserEntity::class
    ], version = DB_VERSION
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getUserDao(): UserDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "database"
    }
}