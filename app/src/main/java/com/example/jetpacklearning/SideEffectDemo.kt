package com.example.jetpacklearning

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

/**
 * You can use SideEffect when you want to treat a non state as state for example you have to execute a code on every successful recomposition
 */
@Composable
fun SideEffectDemo(nonComposeCounter : Int){
    SideEffect {
        println("Called after every successful recomposition")
    }
}