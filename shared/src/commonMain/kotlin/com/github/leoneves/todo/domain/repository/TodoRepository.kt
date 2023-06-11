package com.github.leoneves.todo.domain.repository

import com.github.leoneves.todo.domain.Response
import com.github.leoneves.todo.domain.model.Todo
import com.github.leoneves.todo.domain.model.User

interface TodoRepository {
    suspend fun fetchUserList(): Response<List<User>>
    suspend fun fetchUserDetails(): Response<User>
    suspend fun fetchTodosByUser(userId: Long): Response<List<Todo>>
    suspend fun addTodo(todo: Todo): Response<Todo>
    suspend fun updateTodo(todo: Todo): Response<Todo>
    suspend fun deleteTodo(todo: Todo): Response<Todo>
    suspend fun login(username: String, password: String): Response<String>
}
