package com.ravimaurya.urjanext.ui.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

sealed class Screens(val route: String){
    data object WelcomeScreen: Screens("welcome")
    data object LoginScreen: Screens("login")
    data object RegistrationScreen: Screens("register")
    data object HomeScreen: Screens("home")
}

@Composable
fun MainNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = ""
    ) {

    }
}