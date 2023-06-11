package com.github.leoneves.todo.presentation.flow

open class EventChecker<STATE, EVENT, EFFECT>{
    open lateinit var state: CommonState<STATE>
    open lateinit var effect: CommonState<EFFECT>
    open fun event(event: EVENT){
    }
}