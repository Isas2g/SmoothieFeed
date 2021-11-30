package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.repositories.NetworkingUserRepository

class GetVKUserUseCase(
    private val networkingUserRepository: NetworkingUserRepository
) {
    operator fun invoke() = networkingUserRepository.get("vk")
}