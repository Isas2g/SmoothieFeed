package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.repositories.TokenRepository

class SaveTokenUseCase(
    val tokenRepository: TokenRepository
) {
    suspend operator fun invoke(stringWithToken: String, socialNetworkingName: String) =
        tokenRepository.saveToken(stringWithToken, socialNetworkingName)
}