package com.ravimaurya.urjanext.presentation.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ravimaurya.urjanext.presentation.components.NavBackTopAppBar
import com.ravimaurya.urjanext.presentation.navigation.NavRoutes

@Composable
fun HistoryScreen(navController: NavController) {


    Scaffold(
        topBar = {
            NavBackTopAppBar("History") {
                navController.navigate(NavRoutes.Main_SCREEN2){
                    popUpTo(NavRoutes.HISTORY_SCREEN){ inclusive = true }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("History")
        }
    }
}