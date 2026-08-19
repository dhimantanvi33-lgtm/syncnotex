package com.example.syncnotex.di

import android.content.Context
import androidx.room.Room
import com.example.syncnotex.data.local.dao.NoteDao
import com.example.syncnotex.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "syncnotex_database"
        ).build()
    }

    @Provides
    fun provideNoteDao(
        database: AppDatabase
    ): NoteDao {
        return database.noteDao()
    }
}