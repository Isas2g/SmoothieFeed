package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.repositories.DetoxRepository

class GetDetoxUseCase(
    private val detoxRepository: DetoxRepository
) {
    operator fun invoke() = detoxRepository.get()
}