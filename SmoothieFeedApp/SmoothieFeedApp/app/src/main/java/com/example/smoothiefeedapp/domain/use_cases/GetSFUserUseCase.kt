package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.repositories.SFUserRepository

class GetSFUserUseCase(
    private val sFUserRepository: SFUserRepository,
) {
    suspend operator fun invoke() = sFUserRepository.get()
}