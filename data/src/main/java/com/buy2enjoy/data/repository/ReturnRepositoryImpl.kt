package com.buy2enjoy.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.buy2enjoy.core.database.dao.ReturnItemDao
import com.buy2enjoy.core.database.entity.ReturnItemEntity
import com.buy2enjoy.domain.model.ReturnItem
import com.buy2enjoy.domain.model.ReturnStatus
import com.buy2enjoy.domain.repository.ReturnRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReturnRepositoryImpl @Inject constructor(
    private val dao: ReturnItemDao,
    private val io: CoroutineDispatcher = Dispatchers.IO
) : ReturnRepository {

    private fun ReturnItemEntity.toDomain() = ReturnItem(
        id = id,
        trackingNumber = trackingNumber,
        orderNumber = orderNumber,
        createdDate = createdDateDisplay,
        scanDate = scanDate,
        status = ReturnStatus.valueOf(status),
        monthYear = monthYear
    )

    private fun ReturnItem.toEntity() = ReturnItemEntity(
        id = id,
        trackingNumber = trackingNumber,
        orderNumber = orderNumber,
        createdDateDisplay = createdDate,
        scanDate = scanDate,
        status = status.name,
        monthYear = monthYear
    )

    override suspend fun insertScannedItem(item: ReturnItem): Boolean {
        val insertedId = dao.insertIgnore(item.toEntity())
        return insertedId != -1L
    }

    override suspend fun updateItem(item: ReturnItem) {
        dao.update(item.toEntity())
    }

    override suspend fun markStatus(id: Long, status: ReturnStatus) {
        val current = dao.getById(id) ?: return
        dao.update(current.copy(status = status.name))
    }

    override fun pagedItems(query: String?, monthYear: String?, status: ReturnStatus?, pageSize: Int): Flow<PagingData<ReturnItem>> {
        val like = query?.let { "%${it}%" }
        val statusStr = status?.name
        return Pager(PagingConfig(pageSize = pageSize)) {
            dao.paging(like, monthYear, statusStr)
        }.flow.map { it.map { e -> e.toDomain() } }
    }

    private fun currentMonthYearPkt(): String {
        val zone = java.time.ZoneId.of("Asia/Karachi")
        val now = java.time.ZonedDateTime.now(zone)
        val month = now.monthValue.toString().padStart(2, '0')
        return "${now.year}-$month"
    }

    override fun stats(): Flow<ReturnRepository.Stats> = flow {
        val total = dao.countAll()
        val verified = dao.countVerified()
        val pending = dao.countPending()
        val currentMonth = currentMonthYearPkt()
        val monthCount = dao.countByMonth(currentMonth)
        emit(ReturnRepository.Stats(totalScanned = total, verified = verified, pending = pending, scannedThisMonth = monthCount))
    }

    override suspend fun getByTrackingNumber(trackingNumber: String): ReturnItem? = dao.getByTracking(trackingNumber)?.toDomain()

    override suspend fun getById(id: Long): ReturnItem? = dao.getById(id)?.toDomain()

    override suspend fun itemsForExport(monthYear: String): List<ReturnItem> = dao.itemsByMonth(monthYear).map { it.toDomain() }
}
