package com.github.leoneves.todo.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun LocalDateTime.toISO8601String() = "$year-${monthNumber.twoDecimalString()}-${dayOfMonth.twoDecimalString()}"
fun String.toISO8601LocalDateTime() = LocalDateTime.parse("${this}T12:00:00")

fun getActualDate() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

fun Int.twoDecimalString() = if (this < 10) "0$this" else this.toString()

fun getLastDayOfPreviousMonth(month: Int, year: Int): LocalDateTime {
    val targetMonth = if (month == 1) 12 else month - 1
    val targetYear = if (month == 1) year - 1 else year
    return getLastDayOfMonth(targetMonth, targetYear)
}

fun getLastDayOfMonth(month: Int, year: Int): LocalDateTime {
    val isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0
    val lastDayOfMonth = when (month) {
        2 -> if (isLeapYear) 29 else 28
        1, 3, 5, 7, 8, 10, 12 -> 31
        else -> 30
    }

    return LocalDateTime(year, month, lastDayOfMonth, 0, 0)
}

fun getFirstDayOfNextMonth(month: Int, year: Int): LocalDateTime {
    val targetMonth = if (month == 12) 1 else month + 1
    val targetYear = if (month == 12) year + 1 else year

    return getFirstDayOfMonth(targetMonth, targetYear)
}

fun getFirstDayOfMonth(month: Int, year: Int): LocalDateTime {
    return LocalDateTime(year, month, 1, 0, 0)
}
