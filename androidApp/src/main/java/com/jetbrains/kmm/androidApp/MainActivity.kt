package com.jetbrains.kmm.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.leoneves.todo.TodoSDK
import androidx.activity.compose.setContent
import com.github.leoneves.todo.SharedResources
import com.github.leoneves.todo.data.DatabaseDriverFactory
import com.github.leoneves.todo.di.DependencyInjectionParameters
import com.github.leoneves.todo.presentation.home.HomeViewModelComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TodoSDK.initialize(
            DependencyInjectionParameters(
                application,
                DatabaseDriverFactory(this)
            )
        )
        setContent {
            ContentView(viewModel = HomeViewModelComponent().viewModel())
            SharedResources.strings.my_string.getString(this)
        }

    }
}
