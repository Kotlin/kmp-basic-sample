package com.github.leoneves.todo.presentation.home

import com.github.leoneves.todo.presentation.flow.EventChecker
import com.github.leoneves.todo.domain.usecase.ListUsersUseCase
import com.github.leoneves.todo.presentation.flow.CommonState
import com.github.leoneves.todo.utils.getActualDate

class HomeViewModel(
    private val listUsersUseCase: ListUsersUseCase
) : EventChecker<HomeState, HomeEvent, HomeEffect>() {

    override var state = CommonState(
        HomeState(
            actualMonth = getActualDate().monthNumber,
            actualYear = getActualDate().year
        )
    )

    override var effect = CommonState(HomeEffect)

    override fun event(event: HomeEvent) = when (event){
        HomeEvent.OnNextMonthClick -> Unit
        HomeEvent.OnPreviousMonthClick -> Unit
        HomeEvent.LoadScale -> Unit
    }
}
