package com.github.leoneves.todo.domain.usecase.calendar

import com.github.leoneves.todo.utils.toISO8601String
import kotlin.test.Test
import kotlin.test.assertEquals

class CalendarUseCaseTest {

    @Test
    fun`test generate next month`(){
        val subject = CalendarUseCase()
        var date = subject.getActualDate()
        assertEquals("2023-04-11", date.toISO8601String())
        date = subject.getNextMonth(date.monthNumber, date.year)
        assertEquals("2023-05-01", date.toISO8601String())
        date = subject.getNextMonth(date.monthNumber, date.year)
        assertEquals("2023-06-01", date.toISO8601String())
    }

    @Test
    fun`test generate previous month`(){
        val subject = CalendarUseCase()
        var date = subject.getActualDate()
        assertEquals("2023-04-11", date.toISO8601String())
        date = subject.getPreviousMonth(date.monthNumber, date.year)
        assertEquals("2023-03-01", date.toISO8601String())
        date = subject.getPreviousMonth(date.monthNumber, date.year)
        assertEquals("2023-02-01", date.toISO8601String())
        date = subject.getPreviousMonth(date.monthNumber, date.year)
        assertEquals("2023-01-01", date.toISO8601String())
        date = subject.getPreviousMonth(date.monthNumber, date.year)
        assertEquals("2022-12-01", date.toISO8601String())
    }
}