package com.github.leoneves.todo.data.repository

import com.github.leoneves.todo.data.auth.SecureTokenStorage
import com.github.leoneves.todo.data.model.LoginRequest
import com.github.leoneves.todo.data.network.TodoApi
import com.github.leoneves.todo.domain.Response
import com.github.leoneves.todo.domain.model.Todo
import com.github.leoneves.todo.domain.repository.TodoRepository
import com.github.leoneves.todo.exception.ExpiredTokenException

class TodoRepositoryImpl(
    private val todoApi: TodoApi,
    private val secureTokenStorage: SecureTokenStorage
) : TodoRepository {
    override suspend fun fetchUserList() = makeRequest {
        todoApi.getUsers(secureTokenStorage.getToken()).users
    }

    override suspend fun fetchUserDetails() = makeRequest {
        secureTokenStorage.getToken().let { auth ->
            todoApi.getUserInfo(auth.userId, auth)
        }
    }

    override suspend fun fetchTodosByUser(userId: Long) = makeRequest {
        todoApi.getTodosByUser(userId, secureTokenStorage.getToken()).todos
    }

    override suspend fun addTodo(todo: Todo) = makeRequest {
        todoApi.postTodo(todo, secureTokenStorage.getToken())
    }

    override suspend fun updateTodo(todo: Todo) = makeRequest {
        todoApi.putTodo(todo, secureTokenStorage.getToken())
    }

    override suspend fun deleteTodo(todo: Todo) = makeRequest {
        todoApi.deleteTodo(todo, secureTokenStorage.getToken())
    }

    override suspend fun login(username: String, password: String) = makeRequest {
        val response = todoApi.login(LoginRequest(username, password))
        secureTokenStorage.saveUserInfo(response.id, response.firstName, response.username)
        secureTokenStorage.refreshToken(response.token)
        response.firstName
    }

    private suspend fun <T> makeRequest(
        request: suspend () -> T
    ): Response<T>{
        return try {
            Response.Success.invoke(request())
        }catch (e: Exception){
            if (e is ExpiredTokenException){
                secureTokenStorage.clearToken()
            }
            Response.Fail.invoke(e)
        }
    }

}