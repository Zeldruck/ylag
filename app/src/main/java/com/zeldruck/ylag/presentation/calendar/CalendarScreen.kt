package com.zeldruck.ylag.presentation.calendar

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.zeldruck.ylag.presentation.CEEvents
import com.zeldruck.ylag.presentation.CEventState
import com.zeldruck.ylag.presentation.calendar.components.CalendarAddComp
import com.zeldruck.ylag.presentation.calendar.components.CalendarComp
import com.zeldruck.ylag.presentation.calendar.components.CalendarTaskComp
import com.zeldruck.ylag.presentation.home.components.HomeReminder
import com.zeldruck.ylag.presentation.nav.components.NavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    state: CEventState,
    navController: NavController,
    navHostController: NavHostController,
    onEvent: (CEEvents) -> Unit
) {
    val sState = rememberScrollState()

    Scaffold(
        bottomBar = {
            NavigationBar(navController = navHostController)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                state.title.value = ""
                state.dateTimer.value = 0
                state.category.value = 0
                navController.navigate("ATask")
            }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add new task")
            }
        }
    ) { paddingValues ->
        CalendarComp()

        Spacer(modifier = Modifier.size(25.dp))

        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(sState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.cEvents.size) { index ->
                CalendarTaskComp(state = state, index = index)
            }
        }
    }
}