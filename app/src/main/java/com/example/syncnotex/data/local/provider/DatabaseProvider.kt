package com.example.syncnotex.data.local.provider

import android.content.Context
import androidx.room.Room
import com.example.syncnotex.data.local.database.AppDatabase

object DatabaseProvider {

    fun getDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "syncnotex.db"
        ).build()
    }
}