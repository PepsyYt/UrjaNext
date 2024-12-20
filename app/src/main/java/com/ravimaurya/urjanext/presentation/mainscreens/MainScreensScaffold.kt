package com.ravimaurya.urjanext.presentation.mainscreens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ravimaurya.urjanext.R
import com.ravimaurya.urjanext.presentation.components.BottomUrjaBar
import com.ravimaurya.urjanext.presentation.history.HistoryScreen
import com.ravimaurya.urjanext.presentation.home.HomeScreen
import com.ravimaurya.urjanext.presentation.navigation.NavRoutes
import com.ravimaurya.urjanext.presentation.profile.ProfileScreen
import com.ravimaurya.urjanext.presentation.scanner.ScannerScreen
import com.ravimaurya.urjanext.presentation.station.StationScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreensScaffold(navController: NavHostController){

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier,
                title = { Text("UrjaNext") },
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp),
                        painter = painterResource(R.drawable.logo),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(Icons.Filled.Search,"")
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(Icons.Filled.NotificationsNone,"")
                    }
                }
            )
        },
        bottomBar = {
            BottomUrjaBar(navController)
        }
    ) { innerPadding ->

        Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(innerPadding)
        ) {

            MainNav()

        }

    }

}


@Composable
fun MainNav(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoutes.HOME_SCREEN
    ) {
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
    }
}

