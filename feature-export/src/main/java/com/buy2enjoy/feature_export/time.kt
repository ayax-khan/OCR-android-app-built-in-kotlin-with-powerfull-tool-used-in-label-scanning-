package com.buy2enjoy.feature_export

import java.time.ZoneId
import java.time.ZonedDateTime

fun currentMonthYearPkt(): String {
    val zone = ZoneId.of("Asia/Karachi")
    val now = ZonedDateTime.now(zone)
    val month = now.monthValue.toString().padStart(2, '0')
    return "${now.year}-$month"
}
