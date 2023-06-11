package com.github.leoneves.todo.domain.model

data class TodoList(
    val todos: List<Todo>,
    val total: Long,
    val skip: Long,
    val limit: Long
)
