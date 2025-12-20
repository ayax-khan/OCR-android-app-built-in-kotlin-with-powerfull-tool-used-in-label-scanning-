package com.buy2enjoy.domain.usecase

import com.buy2enjoy.domain.repository.ReturnRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStatsUseCase @Inject constructor(
    private val repository: ReturnRepository
) {
    operator fun invoke(): Flow<ReturnRepository.Stats> = repository.stats()
}
