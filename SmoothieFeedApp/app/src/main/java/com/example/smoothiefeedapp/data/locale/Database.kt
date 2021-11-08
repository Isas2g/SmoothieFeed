package com.example.smoothiefeedapp.data.locale

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object Database {
    lateinit var appDatabase: AppDatabase
        private set

    fun init(context: Context){
        appDatabase = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        )
            .build()
    }
}