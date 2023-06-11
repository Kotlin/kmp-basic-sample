package com.github.leoneves.todo.data.dao

import com.github.leoneves.todo.data.AppDatabase
import com.github.leoneves.todo.domain.dao.UserDAO
import com.github.leoneves.todo.domain.model.User

internal class UserDAOImpl(database: AppDatabase) : UserDAO {
    private val dbQuery = database.appDatabaseQueries

    override fun listUsers(): List<User> {
        return dbQuery.findAllUsers(::mapUser).executeAsList()
    }

    override fun listUsersByName(name: String): List<User> {
        return dbQuery.selectAllUsersByName(name, ::mapUser).executeAsList()
    }

    private fun mapUser(
        id: Long,
        firstName: String,
        email: String,
        phone: String,
        lastName: String,
        maidenName: String
    ) = User(
        id,
        firstName,
        email,
        phone,
        lastName,
        maidenName
    )
}
