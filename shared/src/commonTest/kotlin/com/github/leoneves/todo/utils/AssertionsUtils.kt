package com.github.leoneves.todo.utils

import kotlin.test.assertEquals

class AssertionsUtils<T> private constructor(private val actual: T?) {

    fun isEqualsTo(expected: T) {
        assertEquals(expected, actual)
    }

    fun isTrue() = actual == true

    fun isFalse() = actual == false

    fun isNull() = actual == null

    fun isNotNull() = actual != null

    companion object {
        fun <T> assertThat(actual: T?): AssertionsUtils<T> {
            return AssertionsUtils(actual)
        }
    }
}