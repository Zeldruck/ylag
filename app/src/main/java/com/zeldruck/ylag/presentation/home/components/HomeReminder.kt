package com.zeldruck.ylag.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun HomeReminder() {
    Row (
        modifier = Modifier
            .background(Color(0xffd3d3d3))
            .fillMaxWidth()
            .height(75.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    )
    {
        Text(text = "09:00", fontSize = 18.sp)
        Text(text = "Short description", fontSize = 18.sp)
        Column(
            modifier = Modifier
                .background(Color.Green)
                .padding(10.dp, 0.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Reward", fontSize = 18.sp)
        }
    }
}