package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.repositories.SFUserRepository

class AuthSFUserUseCase(
    private val sFUserRepository: SFUserRepository,
) {
    suspend operator fun invoke(email: String, password: String) =
        sFUserRepository.auth(email, password)
}