package com.example.smoothiefeedapp.data.key_value

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatastoreRepository(context: Context) {

    private val Context.dataStore by preferencesDataStore(
        name = DATASTORE_NAME
    )

    private val dataStore = context.dataStore

    suspend fun saveVKToken(url: String?) {
        dataStore.edit { db ->
                db[VK_KEY] = takeTokenFromUrl(url)
        }
    }

    suspend fun userIsLogged(userIsLogged: Boolean){
        dataStore.edit { db ->
            db[USER_IS_LOGGED_KEY] = userIsLogged
        }
    }

    fun observeVKTokenChanges(): Flow<String?> =
        dataStore.data.map { it[VK_KEY] }

    fun observeUserLogging(): Flow<Boolean?> =
        dataStore.data.map { it[USER_IS_LOGGED_KEY] }

    companion object {
        private const val DATASTORE_NAME = "datastore"
        private val VK_KEY = stringPreferencesKey("vk_key")
        private val USER_IS_LOGGED_KEY = booleanPreferencesKey("user_is_logged_key")
    }

    private fun takeTokenFromUrl(url: String?): String {
        return url?.subSequence(url.indexOf("=") + 1, url.indexOf("&")).toString()
    }
}