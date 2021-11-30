package com.example.smoothiefeedapp.domain.use_cases

import com.example.smoothiefeedapp.domain.repositories.TokenRepository

class ListenTokenChangesUseCase(
    val tokenRepository: TokenRepository
) {
    operator fun invoke(socialNetworkingName: String) =
        tokenRepository.getToken(socialNetworkingName)
}