package com.example.smoothiefeedapp

import android.app.Application
import com.example.smoothiefeedapp.data.key_value.DatastoreRepository
import com.example.smoothiefeedapp.data.locale.Database
import timber.log.Timber

class MainApplication: Application() {
    lateinit var datastoreRepository: DatastoreRepository

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        datastoreRepository = DatastoreRepository(this)
        Database.init(this)
    }
}