package com.buy2enjoy.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.buy2enjoy.core.database.dao.ReturnItemDao
import com.buy2enjoy.core.database.entity.ReturnItemEntity

@Database(
    entities = [ReturnItemEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun returnItemDao(): ReturnItemDao
}
