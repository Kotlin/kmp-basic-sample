package com.github.leoneves.todo

import com.github.leoneves.todo.di.DependencyInjectionParameters
import com.github.leoneves.todo.di.modules.ApiModule
import com.github.leoneves.todo.di.modules.DatabaseModule
import com.github.leoneves.todo.di.modules.HttpModule
import com.github.leoneves.todo.di.modules.RepositoryModule
import com.github.leoneves.todo.di.modules.StorageModule
import com.github.leoneves.todo.di.modules.UseCaseModule
import com.github.leoneves.todo.di.modules.ViewModelModule
import org.koin.core.context.startKoin

object TodoSDK {

    fun initialize(dependencyInjectionParameters: DependencyInjectionParameters){
        startKoin {
            modules(
                HttpModule().provide(),
                StorageModule(dependencyInjectionParameters.kmmContext).provide(),
                ApiModule().provide(),
                DatabaseModule(dependencyInjectionParameters.databaseDriverFactory).provide(),
                RepositoryModule().provide(),
                UseCaseModule().provide(),
                ViewModelModule().provide()
            )
        }
    }
}
