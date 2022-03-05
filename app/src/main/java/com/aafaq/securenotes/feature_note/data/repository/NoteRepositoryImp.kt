package com.aafaq.securenotes.feature_note.data.repository

import com.aafaq.securenotes.feature_note.data.data_source.NoteDao
import com.aafaq.securenotes.feature_note.domain.models.Note
import com.aafaq.securenotes.feature_note.domain.repository.NoteRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImp(
    private val noteDao: NoteDao
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
       return noteDao.getNotes()
    }

    override fun getNoteByID(id: Int): Note? {
       return noteDao.getNoteByID(id)
    }

    override suspend fun deleteNoteByID(id: Int) {
        noteDao.deleteNoteByID(id)
    }

    override suspend fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    override suspend fun insertNote(note: Note) {
        noteDao.deleteNote(note)
    }
}