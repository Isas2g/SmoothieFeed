package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.enteties.NewSFUser
import com.example.smoothiefeedapp.domain.repositories.SFUserRepository

class CreateNewSFUserUseCase(
    private val sfUserRepository: SFUserRepository
) {
    suspend operator fun invoke(newSFUser: NewSFUser) = sfUserRepository.createNew(newSFUser)
}