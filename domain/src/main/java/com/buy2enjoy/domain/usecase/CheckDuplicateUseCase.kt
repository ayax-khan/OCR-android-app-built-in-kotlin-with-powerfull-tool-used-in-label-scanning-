package com.buy2enjoy.domain.usecase

import com.buy2enjoy.domain.model.ReturnItem
import com.buy2enjoy.domain.repository.ReturnRepository
import javax.inject.Inject

class CheckDuplicateUseCase @Inject constructor(
    private val repository: ReturnRepository
) {
    suspend operator fun invoke(trackingNumber: String): ReturnItem? = repository.getByTrackingNumber(trackingNumber)
}
