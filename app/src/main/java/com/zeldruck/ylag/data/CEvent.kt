package com.zeldruck.ylag.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CEvent(
    var title: String,
    val dateTimer: Long,
    val dateDay: Int,
    val dateMonth: Int,
    val dateYear: Int,
    val dateAdded: Long,

    val category: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
