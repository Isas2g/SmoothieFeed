package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.enteties.PostsDetox
import com.example.smoothiefeedapp.domain.repositories.DetoxRepository

class SavePostsDetoxUseCase(
    private val detoxRepository: DetoxRepository
) {
    suspend operator fun invoke(postsDetox: PostsDetox) = detoxRepository.save(postsDetox)
}