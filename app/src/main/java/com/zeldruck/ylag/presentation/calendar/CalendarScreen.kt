package com.zeldruck.ylag.presentation.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zeldruck.ylag.presentation.calendar.components.CalendarAddComp
import com.zeldruck.ylag.presentation.calendar.components.CalendarComp
import com.zeldruck.ylag.presentation.calendar.components.CalendarTaskComp

@Preview(showBackground = true)
@Composable
fun CalendarScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalendarComp()
        Spacer(modifier = Modifier.size(25.dp))
        CalendarAddComp()
        Spacer(modifier = Modifier.size(25.dp))
        CalendarTaskComp("09:00", "Short description")
        Spacer(modifier = Modifier.size(10.dp))
        CalendarTaskComp("15:00", "Short description")
        Spacer(modifier = Modifier.size(10.dp))
        CalendarTaskComp("21:00", "Short description")
        Spacer(modifier = Modifier.size(10.dp))
    }
}