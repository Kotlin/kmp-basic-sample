package com.github.leoneves.todo.presentation.flow

interface UnidirectionalViewModel<STATE: Any, EVENT: Any, EFFECT: Any> {
    val state: CommonState<STATE>
    val effect: CommonState<EFFECT>
    fun event(event: EVENT)
}
