package com.example.jetpacklearning

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.animation.core.Animatable

@Composable
fun LaunchedEffectDemo(
    viewModel: LaunchedEffectViewModel
){
    LaunchedEffect(key1 = true){
        viewModel.sharedFlow.collect{ event ->
            when(event){
                is LaunchedEffectViewModel.ScreenEvents.ShowSnackBar -> {

                }

                is LaunchedEffectViewModel.ScreenEvents.Navigate -> {

                }
            }
        }
    }
}

@Composable
fun LaunchedEffectAnimation(
    counter : Int
){
    val animateAble = remember{
        Animatable(0f)
    }

    LaunchedEffect(key1 = counter){
        animateAble.animateTo(counter.toFloat())
    }
}

