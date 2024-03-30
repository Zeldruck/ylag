package com.zeldruck.ylag.presentation.nav

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.*

data class Case(val name:String,
                val icon: ImageVector
)

val cases = listOf(
    Case(
        name = "Home",
        icon = Icons.Filled.Home
    ),
    Case(
        name = "Schedule",
        icon = Icons.Filled.Notifications
    ),
    Case(
        name = "Achievements",
        icon = Icons.Filled.Star
    ),
    Case(
        name = "Profile",
        icon = Icons.Filled.AccountCircle
    )
)
