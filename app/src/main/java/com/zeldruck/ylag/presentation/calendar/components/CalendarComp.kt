package com.zeldruck.ylag.presentation.calendar.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
    val currentWeek = remember { LocalDate.now() }
    val startWeek = remember { currentWeek.minusDays(7) }
    val endWeek = remember { currentWeek.plusDays(7) }
    val daysOfWeek = daysOfWeek(firstDayOfWeek = DayOfWeek.MONDAY) // Available in the library

    val state = rememberWeekCalendarState(
        startDate = startWeek,
        endDate = endWeek,
        firstVisibleWeekDate = currentWeek,
        firstDayOfWeek = daysOfWeek.first()
    )

    var selectedDate by remember { mutableStateOf<LocalDate?>(currentWeek) }

    Column(
        modifier = Modifier
            .background(Color(0xffd3d3d3))
    ) {
        DaysOfWeekTitle(daysOfWeek = daysOfWeek) // Use the title here
        WeekCalendar(
            state = state,
            dayContent = { day ->
                Day(day, isSelected = selectedDate == day.date) { day ->
                    selectedDate = if (selectedDate == day.date) null else day.date
                }
            }
        )
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
                enabled = day.position == WeekDayPosition.RangeDate,
                onClick = { onClick(day) }
            ), // This is important for square sizing!
        contentAlignment = Alignment.Center
    ) {
        Text(text = day.date.dayOfMonth.toString())
    }
}