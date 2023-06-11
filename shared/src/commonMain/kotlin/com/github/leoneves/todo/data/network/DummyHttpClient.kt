package com.github.leoneves.todo.data.network

import com.github.leoneves.todo.exception.ExpiredTokenException
import com.github.leoneves.todo.exception.InvalidCredentialsException
import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object DummyHttpClient {

    fun getHttpClient() = HttpClient {
        HttpResponseValidator {
            handleResponseExceptionWithRequest { exception, request ->
                val clientException = exception as? ClientRequestException
                    ?: return@handleResponseExceptionWithRequest
                val exceptionResponse = clientException.response
                throw when (exceptionResponse.status) {
                    HttpStatusCode.Unauthorized,
                    HttpStatusCode.InternalServerError -> ExpiredTokenException()
                    HttpStatusCode.BadRequest -> InvalidCredentialsException()
                    else -> clientException
                }
            }
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
            defaultRequest {
                url("https://dummyjson.com/auth/")
                contentType(ContentType.Application.Json)
            }
        }
    }
}
