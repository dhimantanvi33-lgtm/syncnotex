package com.example.syncnotex.data.repository

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val updatedAt: Long,
    val isDeleted: Boolean
)
