package com.github.leoneves.todo.data.auth

import com.github.leoneves.todo.utils.KmmContext

expect class SecureTokenStorage(context: KmmContext) {
    fun refreshToken(token: String)
    fun saveUserInfo(userId: Long, name: String, username: String)
    fun clearToken()
    fun logoutUser()
    fun getToken(): AuthToken
}