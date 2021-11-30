package com.example.smoothiefeedapp.data.implementations

import com.example.smoothiefeedapp.data.daos.TimeDetoxDao
import com.example.smoothiefeedapp.data.enteties.db.TimeDetoxEntity
import com.example.smoothiefeedapp.domain.enteties.TimeDetox
import com.example.smoothiefeedapp.domain.repositories.DetoxRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TimeDetoxRepositoryImpl(
    private val timeDetoxDao: TimeDetoxDao
): DetoxRepository {
    override suspend fun save(detox: Any) {
        if (detox is TimeDetox) timeDetoxDao.addTimeDetoxEntity(TimeDetoxEntity(detox.time))
    }

    override fun get(): Flow<Any?> = timeDetoxDao.getTimeDetoxEntity().map{ timeDetoxEntity ->
        if (timeDetoxEntity==null) null
        else TimeDetox(timeDetoxEntity.time)
    }

    override suspend fun delete() = timeDetoxDao.deleteTimeDetoxEntity()
}