package com.github.leoneves.todo.domain.dao

import com.github.leoneves.todo.domain.model.Todo
import com.github.leoneves.todo.domain.model.User

interface TodoDAO {
    fun insertTodo(todo: String, completed: Boolean, userId: Long)
    fun deleteTodo(id: Long)
    fun updateTodo(id: Long, todo: String, completed: Boolean, userId: Long)
    fun deleteAll()
    fun listTodosByUser(userId: Long): List<Todo>
}