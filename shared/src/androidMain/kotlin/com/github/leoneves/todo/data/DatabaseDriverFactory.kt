package com.github.leoneves.todo.data

import android.content.Context
import com.github.leoneves.todo.SharedResources
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        SharedResources.strings.my_string.getString(context)
        return AndroidSqliteDriver(AppDatabase.Schema, context, "test.db")
    }
}