package com.buy2enjoy.core.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "return_items",
    indices = [
        Index(value = ["trackingNumber"], unique = true),
        Index(value = ["monthYear"]),
        Index(value = ["scanDate"]),
        Index(value = ["status"])
    ]
)
data class ReturnItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val trackingNumber: String,
    val orderNumber: String?,
    val createdDateDisplay: String?, // dd MMM yyyy
    val scanDate: Long, // epoch millis
    val status: String, // enum name
    val monthYear: String // yyyy-MM
)
