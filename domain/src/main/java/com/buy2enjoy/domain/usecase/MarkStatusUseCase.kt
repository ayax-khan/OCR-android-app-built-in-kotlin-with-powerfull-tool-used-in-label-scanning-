package com.buy2enjoy.domain.usecase

import com.buy2enjoy.domain.model.ReturnStatus
import com.buy2enjoy.domain.repository.ReturnRepository
import javax.inject.Inject

class MarkStatusUseCase @Inject constructor(
    private val repository: ReturnRepository
) {
    suspend operator fun invoke(id: Long, status: ReturnStatus) = repository.markStatus(id, status)
}
