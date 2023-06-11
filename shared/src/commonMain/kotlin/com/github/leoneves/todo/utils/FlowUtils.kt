package com.github.leoneves.todo.utils

import com.github.leoneves.todo.presentation.flow.Cancellable
import com.github.leoneves.todo.presentation.flow.CommonFlow
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

fun <T> Flow<T>.asCommonFlow(): CommonFlow<T> = CommonFlow(this)

fun <T> Flow<T>.collect(onEach: (T) -> Unit, onCompletion: (cause: Throwable?) -> Unit): Cancellable {
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    scope.launch {
        try {
            collect {
                onEach(it)
            }

            onCompletion(null)
        } catch (e: Throwable) {
            onCompletion(e)
        }
    }

    return object : Cancellable {
        override fun cancel() {
            scope.cancel()
        }
    }
}