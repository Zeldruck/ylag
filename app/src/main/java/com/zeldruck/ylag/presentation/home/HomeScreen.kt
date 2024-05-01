package com.zeldruck.ylag.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.zeldruck.ylag.presentation.CEEvents
import com.zeldruck.ylag.presentation.CEventState
import com.zeldruck.ylag.presentation.home.components.HomeReminder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: CEventState,
    navController: NavController,
    navHostController: NavHostController,
    onEvent: (CEEvents) -> Unit
) {
    val sState = rememberScrollState()

    Scaffold(
        bottomBar = {
            com.zeldruck.ylag.presentation.nav.components.NavigationBar(navController = navHostController)
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(sState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.cEvents.size) { index ->
                HomeReminder(state = state, index = index)
            }
        }
    }
}