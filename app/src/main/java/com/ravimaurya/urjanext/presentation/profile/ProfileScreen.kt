package com.ravimaurya.urjanext.presentation.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ravimaurya.urjanext.presentation.auth.AuthenticationViewModel
import com.ravimaurya.urjanext.presentation.components.AlertDialogUrja
import com.ravimaurya.urjanext.presentation.components.NavBackTopAppBar
import com.ravimaurya.urjanext.presentation.navigation.NavRoutes


@Composable
fun ProfileScreen(navController: NavController, authenticationViewModel: AuthenticationViewModel = hiltViewModel()) {

    var isLogoutClicked by remember{
        mutableStateOf(false)
    }

    if (isLogoutClicked){
        AlertDialogUrja(
            title = "Logout",
            text = "Are you sure? Want to logout?",
            onConfirmClick = {
                authenticationViewModel.logout()
                navController.navigate(NavRoutes.AUTHENTICATION_SCREEN){
                    popUpTo(0){
                        inclusive = true
                    }
                }
            },
            onDismissClick = { isLogoutClicked = false }
        )
    }

    Scaffold(
        topBar = {
            NavBackTopAppBar("Profile") {
                navController.navigate(NavRoutes.Main_SCREEN2){
                    popUpTo(NavRoutes.PROFILE_SCREEN){ inclusive = true }
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
            Text("Profile")
            Spacer(Modifier.height(20.dp))

            Button(
                onClick = {
                    isLogoutClicked = true
                }
            ) {
                Text("Logout")
            }
        }
    }

}