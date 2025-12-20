package com.buy2enjoy.core.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.buy2enjoy.core.database.entity.ReturnItemEntity

@Dao
interface ReturnItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIgnore(item: ReturnItemEntity): Long

    @Update
    suspend fun update(item: ReturnItemEntity)

    @Query("SELECT * FROM return_items WHERE id = :id")
    suspend fun getById(id: Long): ReturnItemEntity?

    @Query("SELECT * FROM return_items WHERE trackingNumber = :tracking LIMIT 1")
    suspend fun getByTracking(tracking: String): ReturnItemEntity?

    @Query(
        "SELECT * FROM return_items " +
            "WHERE (:query IS NULL OR trackingNumber LIKE :query OR orderNumber LIKE :query) " +
            "AND (:month IS NULL OR monthYear = :month) " +
            "AND (:status IS NULL OR status = :status) " +
            "ORDER BY scanDate DESC"
    )
    fun paging(
        query: String?,
        month: String?,
        status: String?
    ): PagingSource<Int, ReturnItemEntity>

    @Query("SELECT COUNT(*) FROM return_items")
    suspend fun countAll(): Long

    @Query("SELECT COUNT(*) FROM return_items WHERE status = 'VERIFIED'")
    suspend fun countVerified(): Long

    @Query("SELECT COUNT(*) FROM return_items WHERE status = 'PENDING_VERIFICATION' OR status = 'SCANNED'")
    suspend fun countPending(): Long

    @Query("SELECT COUNT(*) FROM return_items WHERE monthYear = :month")
    suspend fun countByMonth(month: String): Long

    @Query("SELECT * FROM return_items WHERE monthYear = :month ORDER BY scanDate DESC")
    suspend fun itemsByMonth(month: String): List<ReturnItemEntity>
}
