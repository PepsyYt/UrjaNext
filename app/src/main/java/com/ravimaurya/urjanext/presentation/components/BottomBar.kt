package com.ravimaurya.urjanext.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.EvStation
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ravimaurya.urjanext.presentation.navigation.NavRoutes


@Composable
fun BottomUrjaBar(navController: NavController){

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = navController.currentDestination?.route

    BottomAppBar(
        modifier = Modifier
            .drawBehind {
                val strokeWidth = 6f // Thickness of the border
                val color = Color.Green // Color of the border
                drawLine(
                    color = color,
                    start = Offset(0f, 0f), // Start at top-left corner
                    end = Offset(size.width, 0f), // End at top-right corner
                    strokeWidth = strokeWidth
                )
            }
    ) {
        ConstantItems.BottomNavItems.forEach { bottomItem ->
            NavigationBarItem(
                label = { Text(bottomItem.label) },
                selected = currentRoute == bottomItem.route,
                icon = { Icon(bottomItem.icon, "") },
                onClick = {
                    if (bottomItem.route != NavRoutes.HOME_SCREEN) {
                        navController.navigate(bottomItem.route) {
                            popUpTo(bottomItem.route) { inclusive = true }
                        }
                    }
                },
                alwaysShowLabel = true
            )
        }
    }

}

data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: ImageVector,
)

object ConstantItems{
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            route = NavRoutes.HOME_SCREEN,
            icon = Icons.Filled.Home
        ),
        BottomNavItem(
            label = "Station",
            route = NavRoutes.STATION_SCREEN,
            icon = Icons.Filled.EvStation
        ),
        BottomNavItem(
            label = "Scan",
            route = NavRoutes.SCANQR_SCREEN,
            icon = Icons.Filled.QrCodeScanner
        ),
        BottomNavItem(
            label = "History",
            route = NavRoutes.HISTORY_SCREEN,
            icon = Icons.Filled.DeleteOutline
        ),
        BottomNavItem(
            label = "Profile",
            route = NavRoutes.PROFILE_SCREEN,
            icon = Icons.Filled.Person
        )
    )
}