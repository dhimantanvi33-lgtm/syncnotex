package com.example.syncnotex.data.repository

import com.example.syncnotex.data.local.entity.NoteEntity

fun NoteEntity.toNote(): Note {
    return Note(
        id = this.id,
        title = this.title,
        content = this.content,
        updatedAt = this.updatedAt,
        isDeleted = this.isDeleted
    )
}

fun Note.toEntity(): NoteEntity{
    return NoteEntity(
        id = this.id,
        title = this.title,
        content = this.content,
        updatedAt = this.updatedAt,
        isDeleted = this.isDeleted
    )
}