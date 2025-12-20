package com.buy2enjoy.domain.usecase

import com.buy2enjoy.domain.model.ReturnStatus
import com.buy2enjoy.domain.repository.ReturnRepository
import javax.inject.Inject

class MarkVerifiedUseCase @Inject constructor(
    private val repository: ReturnRepository
) {
    suspend operator fun invoke(id: Long) = repository.markStatus(id, ReturnStatus.VERIFIED)
}
