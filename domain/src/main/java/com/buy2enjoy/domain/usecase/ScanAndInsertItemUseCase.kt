package com.buy2enjoy.domain.usecase

import com.buy2enjoy.domain.model.ReturnItem
import com.buy2enjoy.domain.model.ReturnStatus
import com.buy2enjoy.domain.repository.ReturnRepository
import com.buy2enjoy.domain.util.Time
import java.time.ZonedDateTime
import javax.inject.Inject

class ScanAndInsertItemUseCase @Inject constructor(
    private val repository: ReturnRepository
) {
    data class Params(
        val trackingNumber: String,
        val orderNumber: String?,
        val createdDateDisplay: String? // dd MMM yyyy if available from OCR
    )

    sealed class Result {
        data class Inserted(val item: ReturnItem): Result()
        data class Duplicate(val existing: ReturnItem): Result()
        data class Invalid(val reason: String): Result()
    }

    suspend operator fun invoke(params: Params): Result {
        val tn = params.trackingNumber.trim()
        if (tn.isEmpty()) return Result.Invalid("Empty tracking number")

        // Determine initial status: SCANNED (manual transitions only)
        val nowMillis = Time.nowEpochMillis()
        val monthYear = Time.currentMonthYear()

        val item = ReturnItem(
            id = 0L,
            trackingNumber = tn,
            orderNumber = params.orderNumber?.trim()?.ifEmpty { null },
            createdDate = params.createdDateDisplay?.trim()?.ifEmpty { null },
            scanDate = nowMillis,
            status = ReturnStatus.SCANNED,
            monthYear = monthYear
        )

        val existing = repository.getByTrackingNumber(tn)
        if (existing != null) return Result.Duplicate(existing)

        val ok = repository.insertScannedItem(item)
        return if (ok) Result.Inserted(item) else Result.Duplicate(repository.getByTrackingNumber(tn)!!)
    }
}
