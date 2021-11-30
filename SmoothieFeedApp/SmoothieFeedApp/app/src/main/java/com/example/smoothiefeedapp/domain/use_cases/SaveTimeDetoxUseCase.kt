package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.enteties.TimeDetox
import com.example.smoothiefeedapp.domain.repositories.DetoxRepository

class SaveTimeDetoxUseCase(
    private val detoxRepository: DetoxRepository
) {
    suspend operator fun invoke(timeDetox: TimeDetox) = detoxRepository.save(timeDetox)
}