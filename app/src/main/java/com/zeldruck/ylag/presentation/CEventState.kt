package com.zeldruck.ylag.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.zeldruck.ylag.data.CEvent

data class CEventState(
    val cEvents : List<CEvent> = emptyList(),
    val title: MutableState<String> = mutableStateOf(""),
    val dateTimer: MutableState<Long> = mutableStateOf(0),
    val category: MutableState<Int> = mutableStateOf(0),
)