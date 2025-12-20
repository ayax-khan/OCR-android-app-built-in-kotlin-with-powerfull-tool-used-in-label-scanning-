package com.buy2enjoy.domain.model

data class ReturnItem(
    val id: Long = 0L,
    val trackingNumber: String,
    val orderNumber: String?,
    val createdDate: String?, // display: dd MMM yyyy
    val scanDate: Long, // epoch millis
    val status: ReturnStatus,
    val monthYear: String // yyyy-MM
)
