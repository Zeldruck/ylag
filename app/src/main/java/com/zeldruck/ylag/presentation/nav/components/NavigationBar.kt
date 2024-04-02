package com.zeldruck.ylag.presentation.nav.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zeldruck.ylag.presentation.nav.cases

@Composable
fun NavigationBar(navController: NavHostController) {
    androidx.compose.material3.NavigationBar {
        val currentRoute = currentRoute(navController)
        cases.forEachIndexed{ _, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = currentRoute == item.name,
                alwaysShowLabel = false,
                onClick = { if (currentRoute != item.name) navController.navigate(item.name)}
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString("KEY_ROUTE")
}