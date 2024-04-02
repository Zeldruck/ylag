package com.zeldruck.ylag.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zeldruck.ylag.presentation.home.components.HomeReminder

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column (
            modifier = Modifier
                .padding(0.dp, 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Today", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            HomeReminder()
            Spacer(modifier = Modifier.height(10.dp))
            HomeReminder()
            Spacer(modifier = Modifier.height(10.dp))
            HomeReminder()
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier
                .padding(0.dp, 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "02/04/2024", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            HomeReminder()
            Spacer(modifier = Modifier.height(10.dp))
            HomeReminder()
            Spacer(modifier = Modifier.height(10.dp))
            HomeReminder()
        }
    }
}