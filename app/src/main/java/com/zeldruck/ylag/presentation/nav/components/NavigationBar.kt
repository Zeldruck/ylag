package com.zeldruck.ylag.presentation.nav.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import com.zeldruck.ylag.presentation.nav.cases

@Preview
@Composable
fun NavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }

    androidx.compose.material3.NavigationBar() {
        cases.forEachIndexed{ index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}