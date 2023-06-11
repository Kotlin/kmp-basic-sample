package com.jetbrains.kmm.androidApp

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.leoneves.todo.presentation.home.HomeEvent.OnNextMonthClick
import com.github.leoneves.todo.presentation.home.HomeEvent.OnPreviousMonthClick
import com.github.leoneves.todo.presentation.flow.CommonState
import com.github.leoneves.todo.presentation.home.HomeViewModel

@Composable
fun ContentView(viewModel: HomeViewModel) {
    val actualMonth by viewModel.state.observeAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Total de escalas: $actualMonth")

        Button(onClick = { viewModel.event(OnNextMonthClick) }) {
            Text(text = "Próximo mês")
        }

        Button(onClick = { viewModel.event(OnPreviousMonthClick) }) {
            Text(text = "Mês anterior")
        }
    }
}

@Composable
fun <T: Any> CommonState<T>.observeAsState(): State<T> {
    val state = remember { mutableStateOf(value) }

    DisposableEffect(key1 = this) {
        observe { newValue ->
            state.value = newValue
            Log.i("Estado", "state = $newValue")
        }
        onDispose {
            removeObserver()
        }
    }

    return state
}