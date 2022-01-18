package com.aafaq.securenotes.feature_note.domain.repository

import com.aafaq.securenotes.feature_note.domain.models.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    /**
     * Get all notes
     * */
    fun getNotes(): Flow<List<Note>>

    /**
     * Get Note by ID
     * */
    fun getNoteByID(id: Int): Note?

    /**
     * Delete Note
     * */
    suspend fun deleteNoteByID(id: Int)
    suspend fun deleteAllNotes()
    suspend fun deleteNote(note: Note)

    /**
     * Insert Note
     * */
    suspend fun insertNote(note: Note)

}