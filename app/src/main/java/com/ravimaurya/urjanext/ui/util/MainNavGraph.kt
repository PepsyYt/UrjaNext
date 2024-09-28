package com.ravimaurya.urjanext.ui.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ravimaurya.urjanext.ui.screens.HomeScreen
import com.ravimaurya.urjanext.ui.screens.WelcomeScreen
import com.ravimaurya.urjanext.ui.screens.auth.LoginScreen
import com.ravimaurya.urjanext.ui.screens.auth.RegistrationScreen

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
        composable(Screens.WelcomeScreen.route) {
            WelcomeScreen()
        }
         composable(Screens.LoginScreen.route) {
            LoginScreen()
        }
         composable(Screens.RegistrationScreen.route) {
            RegistrationScreen()
        }
         composable(Screens.HomeScreen.route) {
            HomeScreen()
        }

    }
}