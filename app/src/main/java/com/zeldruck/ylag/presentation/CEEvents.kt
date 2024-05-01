package com.zeldruck.ylag.presentation

import com.zeldruck.ylag.data.CEvent

sealed interface CEEvents {
    data class DeleteCE(val cEvent: CEvent) : CEEvents

    data class SaveCE(
        val title: String,
        val dateTimer: Long,
        val category: Int
    ): CEEvents
}