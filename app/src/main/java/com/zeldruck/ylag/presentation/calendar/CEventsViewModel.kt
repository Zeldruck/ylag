package com.zeldruck.ylag.presentation.calendar

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zeldruck.ylag.data.CEvent
import com.zeldruck.ylag.data.CEventDao
import com.zeldruck.ylag.presentation.CEEvents
import com.zeldruck.ylag.presentation.CEventState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.util.Date

class CEventsViewModel(
    private val dao: CEventDao
) : ViewModel() {

    private var cEvents = dao.getCEvents().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private var cEventsDay : List<CEvent> = emptyList();

    val _state = MutableStateFlow(CEventState())
    val state =
        combine(_state, cEvents) { state, cEvents ->
            state.copy(cEvents = cEvents)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), CEventState())

    fun OnEvent(event : CEEvents)
    {
        when(event)
        {
            is CEEvents.DeleteCE ->
            {
                viewModelScope.launch {
                    dao.deleteCEvent(event.cEvent)
                }
            }

            is CEEvents.SaveCE ->
            {
                val date = LocalDate.ofEpochDay(state.value.dateTimer.value)
                val day = date.dayOfMonth
                val month = date.month.value
                val year = date.year

                val cEvent = CEvent(
                    title = state.value.title.value,
                    dateTimer = state.value.dateTimer.value,
                    dateDay = day,
                    dateMonth = month,
                    dateYear = year,
                    category = state.value.category.value,
                    dateAdded = System.currentTimeMillis()
                )

                viewModelScope.launch {
                    dao.upsertCEvent(cEvent)
                }

                _state.update {
                    it.copy(
                        title = mutableStateOf(""),
                        dateTimer = mutableStateOf(0),
                        category = mutableStateOf(0)
                    )
                }
            }
        }
    }
}