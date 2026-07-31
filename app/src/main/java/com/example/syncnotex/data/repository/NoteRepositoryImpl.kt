package com.example.syncnotex.data.repository

import com.example.syncnotex.data.local.dao.NoteDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { noteEntities ->
            noteEntities.map { it.toNote() }
        }
    }

    override suspend fun createNote(
        title: String,
        content: String
    ) {
        val note = Note(
            id = UUID.randomUUID().toString(),
            title = title,
            content = content,
            updatedAt = System.currentTimeMillis(),
            isDeleted = false
        )

        noteDao.insertNote(note.toEntity())
    }

    override suspend fun updateNote(
        id: String,
        title: String,
        content: String
    ) {
        val note = Note(
            id = id,
            title = title,
            content = content,
            updatedAt = System.currentTimeMillis(),
            isDeleted = false
        )

        noteDao.updateNote(note.toEntity())
    }

    override suspend fun deleteNote(id: String) {
        noteDao.softDelete(
            id = id,
            updatedAt = System.currentTimeMillis()
        )
    }
}