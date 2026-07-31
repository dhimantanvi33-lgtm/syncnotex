package com.example.syncnotex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.syncnotex.data.repository.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteEditorViewModel(
    private val repository: NoteRepository
) : ViewModel() {

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title

    private val _content = MutableStateFlow("")
    val content: StateFlow<String> = _content

    fun updateTitle(title: String) {
        _title.value = title
    }

    fun updateContent(content: String) {
        _content.value = content
    }

    fun saveNote() {
        viewModelScope.launch {
            repository.createNote(
                title = _title.value,
                content = _content.value
            )
        }
    }

    fun deleteNote(id: String) {
        viewModelScope.launch {
            repository.deleteNote(id)
        }
    }
}