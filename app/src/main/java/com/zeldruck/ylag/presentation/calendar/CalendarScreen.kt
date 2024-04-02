package com.zeldruck.ylag.presentation.calendar

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    val state = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalendarComp()
        Spacer(modifier = Modifier.size(25.dp))
        CalendarAddComp()
        Spacer(modifier = Modifier.size(25.dp))

        repeat(20)
        {
            CTaskPreview()
        }
    }
}

@Composable
fun CTaskPreview() {
    CalendarTaskComp("09:00", "Short description")
    Spacer(modifier = Modifier.size(10.dp))
}