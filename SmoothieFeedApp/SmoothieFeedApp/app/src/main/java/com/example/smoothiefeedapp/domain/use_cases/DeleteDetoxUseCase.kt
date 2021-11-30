package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.repositories.DetoxRepository

class DeleteDetoxUseCase(
    private val detoxRepository: DetoxRepository
) {
    suspend operator fun invoke() = detoxRepository.delete()
}