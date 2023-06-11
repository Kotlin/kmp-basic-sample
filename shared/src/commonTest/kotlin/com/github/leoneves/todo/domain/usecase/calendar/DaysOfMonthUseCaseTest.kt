package com.github.leoneves.todo.domain.usecase.calendar

import com.github.leoneves.todo.domain.usecase.ListUsersUseCase
import com.github.leoneves.todo.utils.AssertionsUtils.Companion.assertThat
import com.github.leoneves.todo.utils.DateAssertionsUtils.Companion.assertDate
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.datetime.Month
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class DaysOfMonthUseCaseTest {
    private lateinit var listUsersUseCase: ListUsersUseCase

    @BeforeTest
    fun setup(){
        listUsersUseCase = mockk()
        every { listUsersUseCase.invoke(any(), any()) } returns emptyList()
    }

    @AfterTest
    fun tearDown(){
        unmockkAll()
    }

    @Test
    fun `verify if DaysOfMonthUseCase return correct last days of previous month`(){
        val subject = DaysOfMonthUseCase(listUsersUseCase)
        val list = subject(1,1993)
        assertThat(list.size).isEqualsTo(6)
        assertThat(list.first().size).isEqualsTo(7)
        assertThat(list.first().first().monthType).isEqualsTo(MonthType.Previous)
        assertDate(list.first().first().time).dayOfMonthIs(27)
        assertDate(list.first().first().time).monthIs(Month.DECEMBER)
        assertDate(list.first().first().time).yearIs(1992)
    }

    @Test
    fun `verify if DaysOfMonthUseCase return correct days of current month`(){
        val subject = DaysOfMonthUseCase(listUsersUseCase)
        val list = subject(1,1993)
        assertThat(list.size).isEqualsTo(6)
        assertThat(list[2].size).isEqualsTo(7)
        assertThat(list[2].first().monthType).isEqualsTo(MonthType.Current)
        assertDate(list[2].first().time).dayOfMonthIs(10)
        assertDate(list[2].first().time).monthIs(Month.JANUARY)
        assertDate(list[2].first().time).yearIs(1993)
    }

    @Test
    fun `verify if DaysOfMonthUseCase return correct first days of next month`(){
        val subject = DaysOfMonthUseCase(listUsersUseCase)
        val list = subject(1,1993)
        assertThat(list.size).isEqualsTo(6)
        assertThat(list.last().size).isEqualsTo(7)
        assertThat(list.last().last().monthType).isEqualsTo(MonthType.Next)
        assertDate(list.last().last().time).dayOfMonthIs(6)
        assertDate(list.last().last().time).monthIs(Month.FEBRUARY)
        assertDate(list.last().last().time).yearIs(1993)
    }
}