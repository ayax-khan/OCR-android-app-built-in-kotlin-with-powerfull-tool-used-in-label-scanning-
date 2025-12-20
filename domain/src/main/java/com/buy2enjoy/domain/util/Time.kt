package com.buy2enjoy.domain.util

import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object Time {
    private val pkt: ZoneId = ZoneId.of("Asia/Karachi")
    private val displayFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy")

    fun nowEpochMillis(): Long = ZonedDateTime.now(pkt).toInstant().toEpochMilli()

    fun currentMonthYear(): String {
        val now = ZonedDateTime.now(pkt)
        val month = now.monthValue.toString().padStart(2, '0')
        return "${now.year}-$month"
    }

    fun formatDisplay(date: ZonedDateTime): String = displayFormatter.format(date)
}
