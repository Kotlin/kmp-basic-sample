package com.jetbrains.basicsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(greet(), Modifier.padding(8.dp))

                    var firstNumber by rememberSaveable { mutableStateOf("") }
                    var secondNumber by rememberSaveable { mutableStateOf("") }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        TextField(
                            value = firstNumber,
                            onValueChange = { firstNumber = it },
                            modifier = Modifier.width(100.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        )
                        Text(text = "+", modifier = Modifier.padding(4.dp))
                        TextField(
                            value = secondNumber,
                            onValueChange = { secondNumber = it },
                            modifier = Modifier.width(100.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        )

                        val first = firstNumber.toIntOrNull()
                        val second = secondNumber.toIntOrNull()
                        Text(
                            text = if (first != null && second != null) {
                                "= ${Calculator.sum(first, second)}"
                            } else {
                                "= \uD83E\uDD14"
                            },
                            modifier = Modifier
                                .width(100.dp)
                                .padding(4.dp)
                        )
                    }
                }
            }
        }
    }
}
