package com.buy2enjoy.data.di

import android.content.Context
import androidx.room.Room
import com.buy2enjoy.core.database.AppDatabase
import com.buy2enjoy.core.database.dao.ReturnItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDb(context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "returns.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideReturnItemDao(db: AppDatabase): ReturnItemDao = db.returnItemDao()
}
