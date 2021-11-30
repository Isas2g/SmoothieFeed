package com.example.smoothiefeedapp.data.implementations

import com.example.smoothiefeedapp.data.apis.VKApi
import com.example.smoothiefeedapp.data.daos.UserDao
import com.example.smoothiefeedapp.data.enteties.api.user.User
import com.example.smoothiefeedapp.data.enteties.db.UserEntity
import com.example.smoothiefeedapp.domain.repositories.NetworkingUserRepository
import com.example.smoothiefeedapp.domain.repositories.TokenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

class NetworkingUserRepositoryImpl(
    private val vkApi: VKApi,
    private val userDao: UserDao,
    private val tokenRepository: TokenRepository
) : NetworkingUserRepository {
    override fun get(socialNetworkingName: String): Flow<List<User>> {
        return userDao.getUserEntitiesList().map { userEntitiesList ->
            userEntitiesList.filterNotNull().map { userEntity ->
                User(
                    id = userEntity.id,
                    firstName = userEntity.firstName,
                    lastName = userEntity.lastName
                )
            }
        }
    }

    override suspend fun load(socialNetworkingName: String) {
        tokenRepository.getToken(socialNetworkingName).collect { token ->
            val user = vkApi.getCurrentUser(token ?: "").response
            userDao.addUserEntity(
                UserEntity(
                    id = user?.id ?: 0,
                    firstName = user?.firstName ?: "",
                    lastName = user?.lastName ?: ""
                )
            )
        }
    }
}