package com.github.leoneves.todo.data.auth

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.leoneves.todo.exception.ExpiredTokenException
import com.github.leoneves.todo.exception.UserNotLoggedException
import com.github.leoneves.todo.utils.KmmContext

actual class SecureTokenStorage actual constructor(context: KmmContext) {

    private val masterKey: MasterKey
    private val sharedPreferences: SharedPreferences

    init {
        masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        sharedPreferences = EncryptedSharedPreferences.create(
            context,
            "PREFS",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    actual fun refreshToken(token: String) {
        sharedPreferences.edit().apply {
            putString("TOKEN", token)
            apply()
        }
    }

    actual fun saveUserInfo(userId: Long, name: String, username: String) {
        sharedPreferences.edit().apply {
            putLong("USER_ID", userId)
            putString("NAME", name)
            putString("USERNAME", username)
            apply()
        }
    }

    actual fun clearToken() {
        sharedPreferences.edit().apply {
            remove("TOKEN")
            apply()
        }
    }

    actual fun getToken(): AuthToken {
        val token = sharedPreferences.getString("TOKEN", null)
        val name = sharedPreferences.getString("NAME", null)
        val username = sharedPreferences.getString("USERNAME", null)

        if (name.isNullOrBlank() || username.isNullOrBlank())
            throw UserNotLoggedException()
        if (token.isNullOrBlank())
            throw ExpiredTokenException()

        return AuthToken(
            token = token,
            userId = sharedPreferences.getLong("USER_ID", 0),
            name = name,
            username = username
        )
    }

    actual fun logoutUser() {
        sharedPreferences.edit().apply {
            remove("TOKEN")
            remove("USER_ID")
            remove("NAME")
            remove("USERNAME")
            apply()
        }
    }
}