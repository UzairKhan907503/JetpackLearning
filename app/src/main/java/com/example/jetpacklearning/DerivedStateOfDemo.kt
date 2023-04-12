package com.example.jetpacklearning

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*

@Composable
fun DerivedStateOfDemo() {
    var counter by remember {
        mutableStateOf(0)
    }

    val counterText = remember {
        derivedStateOf {
            "The counter is $counter"
        }
    }

    Button(onClick = { counter++ }) {
        Text(text = counterText.value)
    }
}