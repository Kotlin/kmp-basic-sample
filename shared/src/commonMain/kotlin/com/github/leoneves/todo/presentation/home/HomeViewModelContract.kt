package com.github.leoneves.todo.presentation.home

data class HomeState(
    val actualMonth: Int,
    val actualYear: Int
)

sealed class HomeEvent {
    object OnNextMonthClick : HomeEvent()
    object OnPreviousMonthClick : HomeEvent()
    object LoadScale : HomeEvent()
}

object HomeEffect {

}