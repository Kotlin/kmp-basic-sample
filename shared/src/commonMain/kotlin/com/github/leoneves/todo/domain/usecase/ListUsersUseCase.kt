package com.github.leoneves.todo.domain.usecase

import com.github.leoneves.todo.domain.repository.TodoRepository

class ListUsersUseCase(
    private val repository: TodoRepository
) {
    suspend operator fun invoke() = repository.fetchUserList()
}