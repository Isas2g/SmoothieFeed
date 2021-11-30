package com.example.smoothiefeedapp.data.implementations

import com.example.smoothiefeedapp.data.daos.PostsDetoxDao
import com.example.smoothiefeedapp.data.enteties.db.PostsDetoxEntity
import com.example.smoothiefeedapp.domain.enteties.PostsDetox
import com.example.smoothiefeedapp.domain.repositories.DetoxRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PostsDetoxRepositoryImpl(
    private val postsDetoxDao: PostsDetoxDao
): DetoxRepository {
    override suspend fun save(detox: Any) {
        if (detox is PostsDetox) postsDetoxDao.addPostsDetoxEntity(PostsDetoxEntity(detox.posts))
    }

    override fun get(): Flow<Any?> = postsDetoxDao.getPostsDetoxEntity().map { postsDetoxEntity ->
        if(postsDetoxEntity==null) null
        else PostsDetox(postsDetoxEntity.posts)
    }

    override suspend fun delete() = postsDetoxDao.deletePostsDetoxEntity()
}