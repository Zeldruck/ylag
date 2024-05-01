package com.zeldruck.ylag.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CEventDao {
    @Upsert
    suspend fun upsertCEvent(cEvent: CEvent)

    @Delete
    suspend fun deleteCEvent(cEvent: CEvent)

    @Query("SELECT * FROM event WHERE day = :day AND month = :month AND year = :year ORDER BY dateTimer")
    fun getCEventsByDay(day: Int, month: Int, year: Int): Flow<List<CEvent>>

    @Query("SELECT * FROM event ORDER BY dateTimer ASC")
    fun getCEvents(): Flow<List<CEvent>>
}