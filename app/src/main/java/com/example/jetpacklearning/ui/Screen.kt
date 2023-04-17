package com.example.jetpacklearning.ui

sealed class Screen(val route : String){
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
//    object MainScreen : Screen("main_screen")

    fun withArgs(vararg args : String) : String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}