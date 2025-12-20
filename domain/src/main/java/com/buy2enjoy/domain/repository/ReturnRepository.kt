package com.buy2enjoy.domain.repository

import androidx.paging.PagingData
import com.buy2enjoy.domain.model.ReturnItem
import com.buy2enjoy.domain.model.ReturnStatus
import kotlinx.coroutines.flow.Flow

interface ReturnRepository {
    suspend fun insertScannedItem(item: ReturnItem): Boolean // returns true if inserted, false if duplicate
    suspend fun updateItem(item: ReturnItem)
    suspend fun markStatus(id: Long, status: ReturnStatus)

    fun pagedItems(
        query: String?, // LIKE on trackingNumber and orderNumber
        monthYear: String?, // yyyy-MM
        status: ReturnStatus?,
        pageSize: Int = 50
    ): Flow<PagingData<ReturnItem>>

    fun stats(): Flow<Stats>

    suspend fun getByTrackingNumber(trackingNumber: String): ReturnItem?
    suspend fun getById(id: Long): ReturnItem?

    suspend fun itemsForExport(monthYear: String): List<ReturnItem>

    data class Stats(
        val totalScanned: Long,
        val verified: Long,
        val pending: Long,
        val scannedThisMonth: Long
    )
}
