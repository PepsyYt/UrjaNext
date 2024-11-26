package com.ravimaurya.urjanext.presentation.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ravimaurya.urjanext.presentation.home.HomeScreen
import com.ravimaurya.urjanext.presentation.welcome.WelcomeScreen
import com.ravimaurya.urjanext.presentation.auth.AuthenticationScreen


object NavRoutes {
    const val WELCOME_SCREEN = "welcome"
    const val AUTHENTICATION_SCREEN = "authentication"
    const val HOME_SCREEN = "home"
    const val WELCOME1_SCREEN = ""
}

@Composable
fun MainNavGraph(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.WELCOME_SCREEN
    ) {
        // Welcome
         composable(NavRoutes.WELCOME_SCREEN) { WelcomeScreen(navController) }
        // Authentication
         composable(NavRoutes.AUTHENTICATION_SCREEN) { AuthenticationScreen() }
        // Home
         composable(NavRoutes.HOME_SCREEN) { HomeScreen() }

    }
}