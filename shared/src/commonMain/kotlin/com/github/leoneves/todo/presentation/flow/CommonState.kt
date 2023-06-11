package com.github.leoneves.todo.presentation.flow

class CommonState<T>(data: T) {
    private var listener: (T) -> Unit = {}
    var value: T = data
        private set

    fun observe(listener: (T) -> Unit) {
        this.listener = listener
        listener(value)
    }

    fun removeObserver() {
        listener = { }
    }

    internal fun update(value: T) {
        this.value = value
        listener(value)
    }
}