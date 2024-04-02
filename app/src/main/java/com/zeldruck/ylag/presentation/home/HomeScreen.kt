package com.zeldruck.ylag.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    val state = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
            .verticalScroll(state),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column (
            modifier = Modifier
                .padding(0.dp, 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Today", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            repeat(3){
                HCompPreview()
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier
                .padding(0.dp, 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "02/04/2024", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            repeat(3){
                HCompPreview()
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier
                .padding(0.dp, 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "03/04/2024", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            repeat(3){
                HCompPreview()
            }
        }
    }
}

@Composable
fun HCompPreview() {
    HomeReminder()
    Spacer(modifier = Modifier.height(10.dp))
}