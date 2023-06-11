package com.github.leoneves.todo.domain

sealed class Response<out S> {

    data class Fail<out S> internal constructor(val value: Exception) : Response<S>() {
        companion object {
            operator fun <S> invoke(f: Exception): Response<S> = Fail(f)
        }
    }

    data class Success<out S> internal constructor(val value: S) : Response<S>() {
        companion object {
            operator fun <S> invoke(s: S): Response<S> = Success(s)
        }
    }

    fun isFail() = this is Fail<*>

    fun isSuccess() = this is Success

    fun fold(
        f: (Exception) -> Unit,
        s: (S) -> Unit
    ) {
        if (this is Fail<*>) {
            f(value)
        } else if (this is Success) {
            s(value)
        }
    }

    companion object {
        fun <S> success(value: S): Response<S> = Success(value)
        fun <F : Exception> fail(value: F): Response<F> = Fail(value)
    }
}