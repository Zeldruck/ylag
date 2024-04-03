package com.zeldruck.ylag.presentation.calendar.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kizitonwose.calendar.compose.WeekCalendar
import com.kizitonwose.calendar.compose.weekcalendar.rememberWeekCalendarState
import com.kizitonwose.calendar.core.*
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*


@Preview(showBackground = true)
@Composable
fun CalendarComp() {
    var currentWeek by remember { mutableStateOf<LocalDate>(LocalDate.now()) }
    val startWeek = remember { currentWeek }
    val endWeek = remember { currentWeek }
    val daysOfWeek = daysOfWeek(firstDayOfWeek = DayOfWeek.MONDAY) // Available in the library

    val state = rememberWeekCalendarState(
        startDate = startWeek,
        endDate = endWeek,
        firstVisibleWeekDate = currentWeek,
        firstDayOfWeek = daysOfWeek.first()
    )

    var selectedDate by remember { mutableStateOf<LocalDate?>(currentWeek) }

    Row {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(60.dp)
                .clickable(
                    onClick = {
                        currentWeek = currentWeek.minusWeeks(1)
                    }
                ),
            contentAlignment = Alignment.Center,

        ) {
            Image(imageVector = Icons.Filled.ArrowBack, contentDescription = "Previous")
        }

        Box(
            modifier = Modifier
                .width(50.dp)
                .height(60.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(imageVector = Icons.Filled.ArrowForward, contentDescription = "Next")
        }

        Column(
            modifier = Modifier
                .background(Color(0xffd3d3d3))
        ) {
            DaysOfWeekTitle(daysOfWeek = daysOfWeek) // Use the title here
            WeekCalendar(
                state = state,
                dayContent = { day ->
                    Day(day, isSelected = selectedDate == day.date) { day ->
                        selectedDate = day.date
                    }
                }
            )
        }
    }
}

@Composable
fun DaysOfWeekTitle(daysOfWeek: List<DayOfWeek>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (dayOfWeek in daysOfWeek) {
            Text(
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()).uppercase()
            )
        }
    }
}

@Composable
fun Day(day: WeekDay, isSelected: Boolean, onClick: (WeekDay) -> Unit) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clip(CircleShape)
            .background(color = if (isSelected) Color.Green else Color.Transparent)
            .clickable(
                //enabled = day.position == WeekDayPosition.RangeDate,
                onClick = { onClick(day) }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = day.date.dayOfMonth.toString())
    }
}