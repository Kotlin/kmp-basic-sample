package com.github.leoneves.todo.data.dao

import com.github.leoneves.todo.data.AppDatabase
import com.github.leoneves.todo.domain.dao.TodoDAO
import com.github.leoneves.todo.domain.model.Todo

internal class TodoDAOImpl(database: AppDatabase) : TodoDAO {
    private val dbQuery = database.appDatabaseQueries

    override fun insertTodo(todo: String, completed: Boolean, userId: Long) {
        dbQuery.insertTodo(todo, completed, userId)
    }

    override fun deleteTodo(id: Long) {
        dbQuery.deleteTodoById(id)
    }

    override fun updateTodo(id: Long, todo: String, completed: Boolean, userId: Long) =
        dbQuery.transaction {
            dbQuery.updateTodo(todo, completed, userId, id)
        }

    override fun deleteAll() {
        dbQuery.removeAllTodos()
        dbQuery.removeAllUser()
    }

    override fun listTodosByUser(userId: Long): List<Todo> {
        return dbQuery.findTodosByUserId(userId, ::mapTodo).executeAsList()
    }

    private fun mapTodo(
        id: Long,
        todo: String,
        completed: Boolean,
        user_id: Long
    ) = Todo(
        id,
        todo,
        completed,
        user_id
    )
}
