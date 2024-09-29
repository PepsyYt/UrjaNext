package com.ravimaurya.urjanext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ravimaurya.urjanext.ui.screens.WelcomeScreen
import com.ravimaurya.urjanext.ui.screens.auth.RegistrationScreen
import com.ravimaurya.urjanext.ui.theme.UrjaNextTheme
import com.ravimaurya.urjanext.ui.util.MainNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UrjaNextTheme {
                val navController = rememberNavController()
                MainNavGraph(navController)

            }
        }
    }
}
