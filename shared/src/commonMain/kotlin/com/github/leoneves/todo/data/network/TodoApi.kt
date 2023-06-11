package com.github.leoneves.todo.data.network

import com.github.leoneves.todo.data.auth.AuthToken
import com.github.leoneves.todo.data.model.LoginRequest
import com.github.leoneves.todo.data.model.LoginResponse
import com.github.leoneves.todo.domain.model.TodoList
import com.github.leoneves.todo.domain.model.UserList
import com.github.leoneves.todo.domain.model.Todo
import com.github.leoneves.todo.domain.model.User
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.HeadersBuilder
import io.ktor.http.HttpHeaders

class TodoApi(private val httpClient: HttpClient) {

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return httpClient.get{
            setBody(loginRequest)
        }.body()
    }

    suspend fun getUserInfo(userId: Long, authToken: AuthToken): User {
        return httpClient.get("users/$userId") {
            headers {
                appendAuth(authToken)
            }
        }.body()
    }

    suspend fun getUsers(authToken: AuthToken): UserList {
        return httpClient.get("users") {
            headers {
                appendAuth(authToken)
            }
        }.body()
    }

    suspend fun getTodosByUser(userId: Long, authToken: AuthToken): TodoList {
        return httpClient.get("todos/user/$userId") {
            headers {
                appendAuth(authToken)
            }
        }.body()
    }

    suspend fun postTodo(todo: Todo, authToken: AuthToken): Todo {
        return httpClient.post("todos/add") {
            headers {
                appendAuth(authToken)
            }
            setBody(todo)
        }.body()
    }

    suspend fun putTodo(todo: Todo, authToken: AuthToken): Todo {
        return httpClient.put("todos/${todo.id}") {
            headers {
                appendAuth(authToken)
            }
            setBody(todo)
        }.body()
    }

    suspend fun deleteTodo(todo: Todo, authToken: AuthToken): Todo {
        return httpClient.delete("todos/${todo.id}") {
            headers {
                appendAuth(authToken)
            }
        }.body()
    }

    private fun HeadersBuilder.appendAuth(authToken: AuthToken) {
        append(HttpHeaders.Authorization, authToken.token)
    }
}