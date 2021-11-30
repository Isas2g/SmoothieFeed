package com.example.smoothiefeedapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.smoothiefeedapp.data.daos.*
import com.example.smoothiefeedapp.data.AppDatabase.Companion.DB_VERSION
import com.example.smoothiefeedapp.data.enteties.db.*

@Database(
    entities = [
        UserEntity::class,
        DetoxEntity::class,
        PostsDetoxEntity::class,
        TimeDetoxEntity::class,
        NewsEntity::class,
        SFUserEntity::class
    ], version = DB_VERSION
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getDetoxDao(): DetoxDao
    abstract fun getPostsDetoxDao(): PostsDetoxDao
    abstract fun getTimeDetoxDao(): TimeDetoxDao
    abstract fun getNewsDao(): NewsDao
    abstract fun getSFUserDao(): SFUserDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "database"
    }
}