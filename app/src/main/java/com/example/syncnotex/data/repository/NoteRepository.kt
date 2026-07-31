package com.example.syncnotex.data.repository

import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun createNote(
       title: String,
       content:String
    )

    suspend fun updateNote(
        id: String,
        title: String,
        content: String
    )
    suspend fun deleteNote(
        id: String
    )
}