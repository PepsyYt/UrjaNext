package com.ravimaurya.urjanext.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.ravimaurya.urjanext.presentation.home.HomeScreen
import com.ravimaurya.urjanext.presentation.welcome.WelcomeScreen
import com.ravimaurya.urjanext.presentation.auth.AuthenticationScreen
import com.ravimaurya.urjanext.presentation.history.HistoryScreen
import com.ravimaurya.urjanext.presentation.mainscreens.MainScreensScaffold
import com.ravimaurya.urjanext.presentation.profile.ProfileScreen
import com.ravimaurya.urjanext.presentation.scanner.ScannerScreen
import com.ravimaurya.urjanext.presentation.splashscreen.SplashScreen
import com.ravimaurya.urjanext.presentation.station.StationScreen


object NavRoutes {
    const val SPLASH_SCREEN = "splash_screen"
    const val WELCOME_SCREEN = "welcome"
    const val AUTHENTICATION_SCREEN = "authentication"
    const val Main_SCREEN = "main"
    const val Main_SCREEN2 = "main2"
    const val HOME_SCREEN = "home"
    const val STATION_SCREEN = "station"
    const val SCANQR_SCREEN = "scanqr"
    const val HISTORY_SCREEN = "history"
    const val PROFILE_SCREEN = "profile"
}



@Composable
fun MainNavGraph(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.SPLASH_SCREEN
    ) {
        // Splash
         composable(NavRoutes.SPLASH_SCREEN) { SplashScreen(navController) }
        // Welcome
         composable(NavRoutes.WELCOME_SCREEN) { WelcomeScreen(navController) }
        // Authentication
         composable(NavRoutes.AUTHENTICATION_SCREEN) { AuthenticationScreen(navController) }

        // Home
        composable(NavRoutes.HOME_SCREEN) { HomeScreen(navController) }
        // Station
        composable(NavRoutes.STATION_SCREEN) { StationScreen(navController) }
        // Scanner
        composable(NavRoutes.SCANQR_SCREEN) { ScannerScreen(navController) }
        // History
        composable(NavRoutes.HISTORY_SCREEN) { HistoryScreen(navController) }
        // Profile
        composable(NavRoutes.PROFILE_SCREEN){ ProfileScreen(navController) }

        navigation(
            startDestination = NavRoutes.Main_SCREEN2,
            route = NavRoutes.Main_SCREEN
        ){
            // MainScreens
            composable(NavRoutes.Main_SCREEN2){ MainScreensScaffold(navController) }

        }


    }
}