package com.zeldruck.ylag.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CEvent::class],
    version = 1
)
abstract class CEventsDatabase : RoomDatabase() {
    abstract val dao : CEventDao
}