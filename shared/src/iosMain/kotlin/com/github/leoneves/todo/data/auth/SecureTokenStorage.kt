package com.github.leoneves.todo.data.auth

import com.github.leoneves.todo.exception.ExpiredTokenException
import com.github.leoneves.todo.exception.UserNotLoggedException
import com.github.leoneves.todo.utils.KmmContext
import platform.Foundation.NSUserDefaults

actual class SecureTokenStorage actual constructor(context: KmmContext){

    actual fun refreshToken(token: String) {
        NSUserDefaults.standardUserDefaults.setObject(token, "TOKEN")
    }

    actual fun saveUserInfo(userId: Long, name: String, username: String) {
        NSUserDefaults.standardUserDefaults.setInteger(userId, "USER_ID")
        NSUserDefaults.standardUserDefaults.setObject(name, "NAME")
        NSUserDefaults.standardUserDefaults.setObject(username, "USERNAME")
    }

    actual fun clearToken() {
        NSUserDefaults.standardUserDefaults.removeObjectForKey("TOKEN")
    }

    actual fun getToken(): AuthToken {
        val token = NSUserDefaults.standardUserDefaults.stringForKey("TOKEN")
        val name = NSUserDefaults.standardUserDefaults.stringForKey("USERNAME")
        val username = NSUserDefaults.standardUserDefaults.stringForKey("NAME")

        if (name.isNullOrBlank() || username.isNullOrBlank())
            throw UserNotLoggedException()
        if (token.isNullOrBlank())
            throw ExpiredTokenException()

        return AuthToken(
            token = token,
            userId = NSUserDefaults.standardUserDefaults.integerForKey("USER_ID"),
            name = name,
            username = username
        )
    }

    actual fun logoutUser() {
        NSUserDefaults.standardUserDefaults.removeObjectForKey("USER_ID")
        NSUserDefaults.standardUserDefaults.removeObjectForKey("NAME")
        NSUserDefaults.standardUserDefaults.removeObjectForKey("USERNAME")
    }

}