package com.example.smoothiefeedapp.data.implementations

import com.example.smoothiefeedapp.data.apis.SFApi
import com.example.smoothiefeedapp.data.daos.SFUserDao
import com.example.smoothiefeedapp.data.enteties.api.SFToken
import com.example.smoothiefeedapp.data.enteties.db.SFUserEntity
import com.example.smoothiefeedapp.domain.enteties.NewSFUser
import com.example.smoothiefeedapp.domain.enteties.SFUser
import com.example.smoothiefeedapp.domain.repositories.SFTokenRepository
import com.example.smoothiefeedapp.domain.repositories.SFUserRepository
import kotlinx.coroutines.flow.map

class SFUserRepositoryImpl(
    private val sFApi: SFApi,
    private val sFUserDao: SFUserDao,
    private val sFTokenRepository: SFTokenRepository
) : SFUserRepository {
    override suspend fun createNew(newSFUser: NewSFUser) {
        sFApi.createUser(
            email = newSFUser.email,
            userName = newSFUser.sFUser.userName,
            password = newSFUser.password
        )
    }

    override suspend fun auth(userName: String, password: String) {
        kotlin.runCatching { sFApi.authUser(userName, password) }
            .onSuccess { sFToken ->
                sFTokenRepository.saveSFToken(sFToken)
                sFUserDao.saveSFUserEntity(SFUserEntity(userName))
            }
    }

    override suspend fun get() = sFUserDao.getSFUserEntity().map { SFUser(it?.userName ?: "") }

    override suspend fun delete() {
        sFTokenRepository.deleteSFToken()
        sFUserDao.deleteSFUserEntity()
    }
}

class SFUserMockRepositoryImpl(
    private val sFUserDao: SFUserDao,
    private val sFTokenRepository: SFTokenRepository
) : SFUserRepository {
    override suspend fun createNew(newSFUser: NewSFUser) {}

    override suspend fun auth(userName: String, password: String) {
        sFTokenRepository.saveSFToken(SFToken(
            token = "Mock_Token",
            refresh = "Mock_Refresh_Token"
        ))
        sFUserDao.saveSFUserEntity(SFUserEntity("Mock_userName"))
    }

    override suspend fun get() = sFUserDao.getSFUserEntity().map { sFUserEntity ->
        if (sFUserEntity==null) null
        else SFUser(sFUserEntity.userName)
    }

    override suspend fun delete() {
        sFTokenRepository.deleteSFToken()
        sFUserDao.deleteSFUserEntity()
    }
}