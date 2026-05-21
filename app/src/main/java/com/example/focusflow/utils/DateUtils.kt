package com.example.focusflow.utils

//class DateUtils {
//}

//package com.focusflow.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    private val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

    fun formatDate(timestamp: Long): String = outputFormat.format(Date(timestamp))

    fun parseDateToTimestamp(dateStr: String): Long {
        return try {
            dateFormat.parse(dateStr)?.time ?: -1L
        } catch (e: Exception) {
            -1L
        }
    }

    fun getCurrentDate(): String = outputFormat.format(Date())

    fun getTodayTimestamp(): Long {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.timeInMillis
    }
}