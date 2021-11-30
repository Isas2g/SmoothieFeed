package com.example.smoothiefeedapp.data.implementations

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.smoothiefeedapp.data.enteties.api.SFToken
import com.example.smoothiefeedapp.domain.repositories.SFTokenRepository
import com.example.smoothiefeedapp.domain.repositories.TokenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatastoreRepositoryImpl(context: Context) : TokenRepository, SFTokenRepository {

    private val Context.dataStore by preferencesDataStore(
        name = DATASTORE_NAME
    )

    private val dataStore = context.dataStore

//    suspend fun saveVKToken(url: String) {
//        dataStore.edit { db ->
//            db[VK_KEY] = takeTokenFromUrl(url)
//        }
//    }

    suspend fun userIsLogged(userIsLogged: Boolean) {
        dataStore.edit { db ->
            db[USER_IS_LOGGED_KEY] = userIsLogged
        }
    }

//    fun observeVKTokenChanges(): Flow<String?> =
//        dataStore.data.map { it[VK_KEY] }

    fun observeUserLogging(): Flow<Boolean?> =
        dataStore.data.map { it[USER_IS_LOGGED_KEY] }

    companion object {
        private const val DATASTORE_NAME = "datastore"
        private val VK_KEY = stringPreferencesKey("vk")
        private val USER_IS_LOGGED_KEY = booleanPreferencesKey("user_is_logged_key")
        private val SF_TOKEN_KEY = stringPreferencesKey("sf_token_key")
        private val SF_REFRESH_TOKEN_KEY = stringPreferencesKey("sf_refresh_token_key")
    }

//    private fun takeTokenFromUrl(stringWithToken: String, socialNetworkName: String): String {
//        return if (socialNetworkName == "vk") url?.subSequence(
//            url.indexOf("=") + 1,
//            url.indexOf("&")
//        ).toString()
//        else url
//    }

    override suspend fun saveToken(stringWithToken: String, socialNetworkName: String) {
        dataStore.edit { db ->
            val token = if (socialNetworkName == "vk") stringWithToken.subSequence(
                stringWithToken.indexOf("=") + 1, stringWithToken.indexOf("&")
            ).toString()
            else stringWithToken
            db[stringPreferencesKey(socialNetworkName)] = token
        }
    }

    override fun getToken(socialNetworkName: String): Flow<String?> =
        dataStore.data.map { it[stringPreferencesKey(socialNetworkName)] }

    override suspend fun saveSFToken(sFToken: SFToken) {
        dataStore.edit { db -> db[SF_TOKEN_KEY] = sFToken.token }
        dataStore.edit { db -> db[SF_REFRESH_TOKEN_KEY] = sFToken.refresh }
    }

    override fun getSFToken() = dataStore.data.map { it[SF_TOKEN_KEY] }

    override fun getSFRefreshToken() = dataStore.data.map { it[SF_REFRESH_TOKEN_KEY] }

    override suspend fun deleteSFToken() {
        dataStore.edit { db -> db[SF_TOKEN_KEY] = "" }
        dataStore.edit { db -> db[SF_REFRESH_TOKEN_KEY] = "" }
    }
}