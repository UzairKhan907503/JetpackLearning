package com.example.jetpacklearning

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay


@Composable
fun RememberUpdateStateDemo(
    onTimeout : () -> Unit
){
    val updateOnTimeOut by rememberUpdatedState(newValue = onTimeout)
    LaunchedEffect(key1 = true){
        delay(3000L)
        updateOnTimeOut()
    }
}