package com.github.leoneves.todo.utils

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month
import kotlin.test.assertEquals

class DateAssertionsUtils private constructor(private val actual: LocalDateTime) {

    fun isEqualsTo(expected: LocalDateTime){
        assertEquals(expected.toISO8601String(), actual.toISO8601String())
    }

    fun monthIs(month: Month){
        assertEquals(month, actual.month)
    }

    fun monthIs(month: Int){
        assertEquals(month, actual.monthNumber)
    }

    fun dayOfWeekIs(dayOfWeek: DayOfWeek){
        assertEquals(dayOfWeek, actual.dayOfWeek)
    }

    fun dayOfMonthIs(dayOfMonth: Int){
        assertEquals(dayOfMonth, actual.dayOfMonth)
    }

    fun yearIs(year: Int){
        assertEquals(year, actual.year)
    }

    companion object{
        fun assertDate(actual: LocalDateTime): DateAssertionsUtils{
            return DateAssertionsUtils(actual)
        }
    }
}