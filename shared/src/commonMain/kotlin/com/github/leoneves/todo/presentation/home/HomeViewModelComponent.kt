package com.github.leoneves.todo.presentation.home

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModelComponent : KoinComponent {
    private val viewModel : HomeViewModel by inject()
    fun viewModel() : HomeViewModel = viewModel
}