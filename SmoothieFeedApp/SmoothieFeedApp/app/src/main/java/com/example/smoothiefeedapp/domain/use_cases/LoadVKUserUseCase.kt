package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.repositories.NetworkingUserRepository

class LoadVKUserUseCase(
    private val networkingUserRepository: NetworkingUserRepository
) {
    suspend operator fun invoke() = networkingUserRepository.load("vk")
}